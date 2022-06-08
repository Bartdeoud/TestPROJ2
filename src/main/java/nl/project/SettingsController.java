package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {


    private Stage stage;
    private Scene scene;

    @FXML
    private ChoiceBox<String> themeCbox;
    @FXML
    private Button btnProfile1;
    @FXML
    private Button btnProfile111;
    @FXML
    private Button btnProfile11;
    @FXML
    private CheckBox Darkmodebox;
    @FXML
    private Button btnProfile112;

    String[] themes = {"Blauw/Wit", "Paars/Zwart", "Rood/Zwart", "Geel/Wit", "Roze/Wit"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        themeCbox.getItems().addAll(themes);
    }

    //Get selected theme
    private String getThemeCBox(ChoiceBox<String> themeCbox){
        String theme = themeCbox.getValue();
        return theme;
    }

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
    void ThemeButtonClicked(ActionEvent event) {
        if(getThemeCBox(themeCbox).equals("Blauw/Wit")){

        }
        else if(getThemeCBox(themeCbox).equals("Paars/Zwart")){

        }
        else if(getThemeCBox(themeCbox).equals("Rood/Zwart")){

        }
        else if(getThemeCBox(themeCbox).equals("Geel/Wit")){

        }
        else if(getThemeCBox(themeCbox).equals("Paars/Wit")){

        }
    }

    //Menu
    @FXML
    Button settingToProfile;
    @FXML
    Button settingToForm;
    @FXML
    Button settingToRanklist;
    @FXML
    Button settingToSettings;


    @FXML
    public void ProfileButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profiel.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(this.getClass().getResource(setTheme()).toExternalForm());
        stage.setMaximized(true);
        stage.setTitle("COnee");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void FormButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(this.getClass().getResource(setTheme()).toExternalForm());
        stage.setMaximized(true);
        stage.setTitle("COnee");
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
        stage.setTitle("COnee");
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
        stage.setTitle("COnee");
        stage.setScene(scene);
        stage.show();
    }


}
