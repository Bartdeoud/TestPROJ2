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
import nl.project.Controller;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPanelController extends Controller {
    /**
     * Child class of Controller
     * Used to control the behaviour of the Admin panel scene
     */

    // Initialize variables
    private final DataHandler database = new DataHandler(getDatabase());

    // Initialize FXML variables
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


    // Modify the defined users attributes to the given attributes in the database
    @FXML
    public void ChangeUser(ActionEvent event) {
        String query = String.format("UPDATE [Users] SET UserName = \"%s\", Password = \"%s\", Points = '%s', AccessLevel = '%s' WHERE UserName = \"%s\"",TFUsername.getText(),TFPassword.getText(),TFPoints.getText(),TFAccesslevel.getText(),TFUserNameToChange.getText());
        System.out.println(query);
        database.runQuery(query);
        clearTextFields();
    }

    // Adds an user with the given attributes to the database
    @FXML
    public void AddUser(ActionEvent event) {
        String query = String.format("INSERT INTO [Users] ([UserName], [Password], [Points], [AccessLevel]) VALUES (\"%s\",\"%s\",%s,%s)",TFUsername.getText(),TFPassword.getText(),TFPoints.getText(),TFAccesslevel.getText());
        database.runQuery(query);
        clearTextFields();
    }

    //  Get the filepath of the database
    public String getDatabase(){
        String filePath = new File("").getAbsolutePath();
        return filePath + "/Databases/project2db.mdb";
    }

    // Clear the used textfields so you can easily use them again
    public void clearTextFields(){
        TFUserNameToChange.setText("");
        TFUsername.setText("");
        TFPassword.setText("");
        TFPoints.setText("");
        TFAccesslevel.setText("");
    }

    // Get the list of users from the database
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

}
