package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Objects;


public abstract class Controller {
    /**
     * Abstract parent class of used controllers
     * Used to Control the behaviour of the buttons for navigation between scenes
     */

    // Initialize variables
    private Stage stage;
    private Scene scene;

    // Initialize FXML variables
    @FXML
    Button btnForm;
    @FXML
    Button btnRanklist;
    @FXML
    Button btnSettings;
    @FXML
    public Button profielToAdminPanel;

    // Move the current scene to the profile scene
    @FXML
    public void ProfileButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profiel.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        String css = Objects.requireNonNull(this.getClass().getResource("lightMode.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setMaximized(true);
        stage.setTitle("COnee");
        stage.setScene(scene);
        stage.show();
    }

    // Move the current scene to the form scene
    @FXML
    public void FormButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        String css = Objects.requireNonNull(this.getClass().getResource("lightMode.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setMaximized(true);
        stage.setTitle("Greetings!");
        stage.setScene(scene);
        stage.show();
    }

    // Move the current scene to the ranklist scene
    @FXML
    public void RanklistButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ranglijst.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        String css = Objects.requireNonNull(this.getClass().getResource("lightMode.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setMaximized(true);
        stage.setTitle("Greetings!");
        stage.setScene(scene);
        stage.show();
    }

    // Move the current scene to the setting scene
    @FXML
    public void SettingsButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Instellingen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        String css = Objects.requireNonNull(this.getClass().getResource("lightMode.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setMaximized(true);
        stage.setTitle("Greetings!");
        stage.setScene(scene);
        stage.show();
    }

}
