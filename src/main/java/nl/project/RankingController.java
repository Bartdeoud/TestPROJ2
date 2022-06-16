package nl.project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;


import java.net.URL;
import java.util.ResourceBundle;

public class RankingController extends Controller implements Initializable {
    /**
     * Child class of Controller
     * Used to control the behaviour of the Ranking scene
     */

    // Initialize variables
    String[] name = {"1.  Bart", "2. Mark", "3.  Hidde", "4. Kevin", "5. Ruben"};
    private String CurrentUser;

    // Initialize FXML variables
    @FXML
    private ListView<String> RankListView;

    // Implement the initialize method from the interface Initializable
    // And loads the ranklist with users
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RankListView.getItems().addAll(name);
        RankListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                CurrentUser = RankListView.getSelectionModel().getSelectedItem();
            }
        });
    }
}
