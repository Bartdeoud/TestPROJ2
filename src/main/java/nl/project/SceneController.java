package nl.project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static nl.project.Login.*;

public class SceneController
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

    public String getTheme(){
        if(scene.getStylesheets().toString().contains("lightMode.css")){
            System.out.println("Found Theme");
            return scene.getStylesheets().toString();
        }
        else if(scene.getStylesheets().toString().contains("darkMode.css")){
            System.out.println("Found Theme");
            return scene.getStylesheets().toString();
        }
        else{
            System.out.printf(scene.getStylesheets().toString());
            return "lightMode.css";
        }
    }

    //Check theme and adding to scene by using contains statement
    public String setTheme(){

        if(getTheme().contains("lightMode.css")){
            return "lightMode.css";
        }
        else if(getTheme().contains("darkMode.css")){
            return "darkMode.css";
        }
        else{
            return "lightMode.css";
        }
    }

    @FXML
    public void profielToAdminPanelClicked(ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(this.getClass().getResource(setTheme()).toExternalForm());
        stage.setMaximized(true);
        stage.setTitle("COnee");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ProfileButtonClicked(ActionEvent event) throws Exception {
        if(login(Username.getText(), password.getText()))
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profiel.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(this.getClass().getResource(setTheme()).toExternalForm());
            stage.setMaximized(true);
            stage.setTitle("Greetings!");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void FormButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(this.getClass().getResource(setTheme()).toExternalForm());
        stage.setMaximized(true);
        stage.setTitle("Greetings!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void RanklistButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ranglijst.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(this.getClass().getResource(setTheme()).toExternalForm());
        stage.setMaximized(true);
        stage.setTitle("Greetings!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void SettingsButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Instellingen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(this.getClass().getResource(setTheme()).toExternalForm());
        stage.setMaximized(true);
        stage.setTitle("Greetings!");
        stage.setScene(scene);
        stage.show();
    }

    //if user has admin permissions give access to admin panel
    @FXML
    public void initialize() {
        if(accessLevel == 1){
            profielToAdminPanel.setVisible(true);
        }
    }
}
