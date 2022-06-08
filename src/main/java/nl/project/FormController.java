package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {


    private Stage stage;
    private Scene scene;

    @FXML
    Button formToProfile;
    @FXML
    Button formToRanklist;
    @FXML
    Button formToSettings;

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

    @FXML
    private ListView<String> RankListView;
    @FXML
    private ListView<String> NmmrListView;
    @FXML
    private ListView<String> NameListView;
    @FXML
    private ListView<String> KMListView;
    @FXML
    private ListView<String> PointsListView;

    String[] nummer = {"1", "2", "3", "4", "5"};
    String[] soort = {"Benzine auto", "Diesel auto", "Electrische Auto", "Openbaar vervoer", "Overige"};
    String[] km = {"12km", "23km", "3km", "4km", "0.5km"};
    String[] punten = {"50pt", "45pt", "40pt", "30pt", "10pt"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NmmrListView.getItems().addAll(nummer);
        NameListView.getItems().addAll(soort);
        KMListView.getItems().addAll(km);
        PointsListView.getItems().addAll(punten);
    }
}
