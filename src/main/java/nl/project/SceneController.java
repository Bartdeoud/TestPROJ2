package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;

import static Handlers.Login.*;

public class SceneController extends Controller
{

    private Stage stage;
    private Scene scene;

    //Menu
    @FXML
    Button btnProfile1;
    @FXML
    Button btnForm;
    @FXML
    Button btnRanklist;
    @FXML
    Button btnSettings;
    @FXML
    public Button profielToAdminPanel;
    @FXML
    TextField Username;
    @FXML
    TextField password;

    //if user has admin permissions give access to admin panel
    @FXML
    public void initialize() {
        if (accessLevel == 1) {
            profielToAdminPanel.setVisible(true);
        }
    }
    @FXML
    public void profielToAdminPanelClicked(ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setMaximized(true);
        stage.setTitle("COnee");
        stage.setScene(scene);
        stage.show();
    }

}




