package nl.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.sql.ResultSet;
import java.sql.SQLException;

import static Handlers.DatabaseHandler.*;

public class AdminPanelController extends Controller {
    /**
     * Child class of Controller
     * Used to control the behaviour of the Admin panel scene
     */

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
        setData("UserName", TFUsername.getText(), TFUserNameToChange.getText());
        setData("Password", TFPassword.getText(), TFUserNameToChange.getText());
        setData("Points", TFPoints.getText(), TFUserNameToChange.getText());
        setData("AccessLevel", TFAccesslevel.getText(), TFUserNameToChange.getText());
        clearTextFields();
    }

    // Adds an user with the given attributes to the database
    @FXML
    public void AddUser(ActionEvent event) {
        String query = String.format("INSERT INTO [Users] ([UserName], [Password], [Points], [AccessLevel], [BenzineAutoKM], [DieselAutoKM], [ElecAutoKM], [OVKM], [VliegtuigKM], [HybridAutoKM]) VALUES (\"%s\",\"%s\",%s,%s, \"0\", \"0\", \"0\", \"0\", \"0\", \"0\")",TFUsername.getText(),TFPassword.getText(),TFPoints.getText(),TFAccesslevel.getText());
        runQuery(query, getDatabasePath());
        clearTextFields();
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
        ResultSet rs = getDataSet("SELECT * FROM [Users]", getDatabasePath());
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
