package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Objects;

import static Handlers.Login.*;

public class ProfileController extends Controller {
    /**
     * Child class of Controller
     * Used to control the behaviour of the Profiel scene
     */

    // Initialize FXML variables
    @FXML
    Button btnForm;
    @FXML
    Button btnRanklist;
    @FXML
    Button btnSettings;
    @FXML
    public Button profielToAdminPanel;

    // Implement the initialize method from the interface Initializable
    // If user has admin permissions give access to admin panel
    @FXML
    public void initialize() {
        if (accessLevel == 1) {
            profielToAdminPanel.setVisible(true);
        }
    }

    // Change the current scene to the admin panel scene
    @FXML
    public void profielToAdminPanelClicked(ActionEvent event) throws Exception{
        nextScene("AdminPanel.fxml",event);
    }

}




