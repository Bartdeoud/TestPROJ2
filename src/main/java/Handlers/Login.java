package Handlers;

import Handlers.DataHandler;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login
{
    public static String loggedInUser;
    public static int accessLevel;
    private static final DataHandler database = getDatabase();

    //returns if password is correct
    public static boolean login(String name, String password){
        String password1 = null;
        ResultSet rs = database.getData(String.format("SELECT * FROM [Users] WHERE UserName = \"%s\"",name));

        try
        {
            while (rs.next())
            {
                saveLoggedInUser(name);
                password1 = rs.getString("Password");
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        if(password1 == null) return false;
        return password.equals(password1);
    }

    //saves data from logged in user
    public static void saveLoggedInUser(String user){
        loggedInUser = user;
        ResultSet rs = database.getData(String.format("SELECT * FROM [Users] WHERE UserName = \"%s\"",user));
        try
        {
            while (rs.next())
            {
                accessLevel = rs.getInt("AccessLevel");
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    //returns the database
    public static DataHandler getDatabase(){
        String filePath = new File("").getAbsolutePath();
        return new DataHandler(filePath + "/Databases/project2db.mdb");
    }
}
