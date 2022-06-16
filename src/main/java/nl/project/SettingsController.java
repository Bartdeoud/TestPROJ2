package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController extends Controller implements Initializable {
    /**
     * Child class of Controller
     * Used to control the behaviour of the Settings scene
     */

    // Initialize variables
    String[] themes = {"Blauw/Wit", "Paars/Zwart", "Rood/Zwart", "Geel/Wit", "Roze/Wit"};

    // Initialize FXML variable
    @FXML
    private ChoiceBox<String> themeCbox;

    // Implement the initialize method from the interface Initializable
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        themeCbox.getItems().addAll(themes);
    }

    //Get selected theme
    private String getThemeCBox(ChoiceBox<String> themeCbox){
        return themeCbox.getValue();
    }

    // Opens dropdown menu with themes
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
}
