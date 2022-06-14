package nl.project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import nl.project.Controller;

import java.net.URL;
import java.util.ResourceBundle;

public class RankingController extends Controller implements Initializable {

    @FXML
    private ListView<String> RankListView;
    @FXML
    private Label RankLabel;

    private String CurrentUser;

    String[] name = {"1.  Bart", "2. Mark", "3.  Hidde", "4. Kevin", "5. Ruben"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RankListView.getItems().addAll(name);
        RankListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                CurrentUser = RankListView.getSelectionModel().getSelectedItem();
                RankLabel.setText(CurrentUser);
            }
        });
    }
}
