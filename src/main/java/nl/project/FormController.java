package nl.project;

import Handlers.SubmissionHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static Handlers.DatabaseHandler.setData;
import static Handlers.DatabaseHandler.getData;
import static Handlers.Login.getLoggedInUser;


public class FormController extends Controller implements Initializable {
    /**
     * Child class of Controller
     * Used to control the behaviour of the Form scene
     */

    // Initialize variables
    String[] nummer = {"1", "2", "3", "4", "5"};
    String[] soort = {"Benzine auto", "Diesel auto", "Electrische Auto", "Openbaar vervoer", "Overige"};
    String[] km = {"12km", "23km", "3km", "4km", "0.5km"};
    String[] punten = {"50pt", "45pt", "40pt", "30pt", "10pt"};

    // Initialize FXML variables
    @FXML
    private ListView<String> NmmrListView;
    @FXML
    private ListView<String> NameListView;
    @FXML
    private ListView<String> KMListView;
    @FXML
    private ListView<String> PointsListView;
    @FXML
    Button submitBtn;
    @FXML
    TextField BenzineAuto;
    @FXML
    TextField OV;
    @FXML
    TextField DieselAuto;
    @FXML
    TextField HybridAuto;
    @FXML
    TextField Vliegtuig;
    @FXML
    TextField ElecAuto;

    // Implement the initialize method from the interface Initializable
    // And shows the initialized variables on the scene
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NmmrListView.getItems().addAll(nummer);
        NameListView.getItems().addAll(soort);
        KMListView.getItems().addAll(km);
        PointsListView.getItems().addAll(punten);
    }

    @FXML
    public void AddKM(ActionEvent event) {
        SubmissionHandler.submissionHandler(BenzineAuto,DieselAuto,ElecAuto,OV,Vliegtuig,HybridAuto);
    }
}
