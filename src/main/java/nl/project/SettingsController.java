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

    //Check theme and adding to all scenes by using contains statement
    public void setTheme(){
        String css = "";
        String currentCss = scene.getStylesheets().toString();
        scene.getStylesheets().remove(currentCss);

        if(currentCss.contains("lightMode.css")){
            css = this.getClass().getResource("lightMode.css").toExternalForm();
        }
        else if(currentCss.contains("darkMode.css")){
            css = this.getClass().getResource("darkMode.css").toExternalForm();
        }
        else{
            css = this.getClass().getResource("lightMode.css").toExternalForm();
        }
        scene.getStylesheets().add(css);
    }

    @FXML
    void ThemeButtonClicked(ActionEvent event) {

        if(getThemeCBox(themeCbox).equals("Blauw/Wit")){
            String css = this.getClass().getResource("lightMode.css").toExternalForm();
            setTheme();
        }
        else if(getThemeCBox(themeCbox).equals("Paars/Zwart")){

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
        setTheme();
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
        setTheme();
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
        setTheme();
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
        setTheme();
        stage.setMaximized(true);
        stage.setTitle("Greetings!");
        stage.setScene(scene);
        stage.show();
    }


}
