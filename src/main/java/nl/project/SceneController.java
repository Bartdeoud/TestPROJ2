package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SceneController {


    private Stage stage;
    private Scene scene;


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
    TextField Username;
    @FXML
    TextField password;

    @FXML
    public void ProfileButtonClicked(ActionEvent event) throws Exception {
        if(login())
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profiel.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
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

    public boolean login(){
        String filePath = new File("").getAbsolutePath();
        String name = Username.getText();
        String password1 = null;
        DataHandler database = new DataHandler(filePath + "/Databases/project2db.mdb");
        ResultSet rs = database.getData("SELECT * FROM [Users]");
        try
        {
            while (rs.next())
            {
                if(rs.getString("UserName").equals(name)){
                    password1 = rs.getString("Password");
                }
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        if(password1 == null) return false;
        return password.getText().equals(password1);
    }
}
