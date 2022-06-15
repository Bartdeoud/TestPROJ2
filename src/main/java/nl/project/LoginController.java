package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static Handlers.Login.loginPasswordCheck;
import static Handlers.Login.setLoggedInUser;

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

    // Changes the login scene to the profile scene if the username and password are correct
    @FXML
    public void LoginButtonClicked(ActionEvent event) throws Exception {
        if(loginPasswordCheck(Username.getText(), password.getText()))
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
