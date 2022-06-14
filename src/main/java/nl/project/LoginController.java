package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static Handlers.Login.login;

public class LoginController extends Controller {
    /**
     * Child class of Controller
     * Used to control the behaviour of the Login scene
     */

    // Initialize variables
    Stage stage;
    Scene scene;

    // Initialize FXML variables
    @FXML
    TextField Username;
    @FXML
    TextField password;

    // Overrides the ProfileButtonClicked so that it checks if the username and password are correct
    // before going to the Profile scene
    @Override
    @FXML
    public void ProfileButtonClicked(ActionEvent event) throws Exception {
        if(login(Username.getText(), password.getText()))
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profiel.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setMaximized(true);
            stage.setTitle("Greetings!");
            stage.setScene(scene);
            stage.show();
        }
    }
}
