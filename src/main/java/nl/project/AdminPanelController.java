package nl.project;

import Handlers.DataHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPanelController
{
    private Stage stage;
    private Scene scene;

    private final DataHandler database = new DataHandler(getDatabase());

    @FXML
    Button btnAPGetUsers;
    @FXML
    TextArea textAreaUsers;
    @FXML
    Button btnChangeUser;
    @FXML
    Button btnAddUser;
    @FXML
    TextField TFUsername;
    @FXML
    TextField TFPassword;
    @FXML
    TextField TFPoints;
    @FXML
    TextField TFAccesslevel;
    @FXML
    TextField TFUserNameToChange;

    @FXML
    public void ChangeUser(ActionEvent event) {
        String query = String.format("UPDATE [Users] SET UserName = \"%s\", Password = \"%s\", Points = '%s', AccessLevel = '%s' WHERE UserName = \"%s\"",TFUsername.getText(),TFPassword.getText(),TFPoints.getText(),TFAccesslevel.getText(),TFUserNameToChange.getText());
        System.out.println(query);
        database.runQuery(query);
        clearTextFields();
    }

    @FXML
    public void AddUser(ActionEvent event) {
        String query = String.format("INSERT INTO [Users] ([UserName], [Password], [Points], [AccessLevel]) VALUES (\"%s\",\"%s\",%s,%s)",TFUsername.getText(),TFPassword.getText(),TFPoints.getText(),TFAccesslevel.getText());
        database.runQuery(query);
        clearTextFields();
    }

    public String getDatabase(){
        String filePath = new File("").getAbsolutePath();
        return filePath + "/Databases/project2db.mdb";
    }

    public void clearTextFields(){
        TFUserNameToChange.setText("");
        TFUsername.setText("");
        TFPassword.setText("");
        TFPoints.setText("");
        TFAccesslevel.setText("");
    }

    @FXML
    public void LoadUsers(ActionEvent event) {
        textAreaUsers.setText("");
        ResultSet rs = database.getData("SELECT * FROM [Users]");
        try
        {
            while (rs.next())
            {
                textAreaUsers.setText(textAreaUsers.getText() + String.format("%d - %s\n",rs.getInt("Count"),rs.getString("UserName")));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @FXML
    public void ProfileButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profiel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
