package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneController {


    private Stage stage;
    private Scene scene;


    public String getTheme(){
      return scene.getStylesheets().toString();
    }

    //Check theme and adding to scene by using contains statement
    public void setTheme(){
        String css = "";

        if(getTheme().contains("lightMode.css")){
            css = scene.getClass().getResource("lightMode.css").toExternalForm();
        }
        else if(getTheme().contains("darkMode.css")){
            css = scene.getClass().getResource("darkMode.css").toExternalForm();
        }
        else if(getTheme() == null){
            css = scene.getClass().getResource("lightMode.css").toExternalForm();
        }
        scene.getStylesheets().add(css);
    }


    //Menu
    @FXML
    Button btnProfile;
    @FXML
    Button btnForm;
    @FXML
    Button btnRanklist;
    @FXML
    Button btnSettings;

    @FXML
    public void ProfileButtonClicked(ActionEvent event) throws Exception {
        setTheme();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profiel.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setMaximized(true);
        stage.setTitle("Greetings!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void FormButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
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
        stage.setMaximized(true);
        stage.setTitle("Greetings!");
        stage.setScene(scene);
        stage.show();
    }
}
