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
import java.util.Objects;

import static Handlers.Login.*;

public class SceneController extends Controller
{

    //Menu
    @FXML
    Button btnForm;
    @FXML
    Button btnRanklist;
    @FXML
    Button btnSettings;
    @FXML
    public Button profielToAdminPanel;

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
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        String css = Objects.requireNonNull(this.getClass().getResource("lightMode.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setMaximized(true);
        stage.setTitle("COnee");
        stage.setScene(scene);
        stage.show();
    }

}




