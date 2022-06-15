package Handlers;

import java.io.File;
import java.sql.*;

public class DatabaseHandler {

    // Get the path to the database file
    public static String getDatabasePath() {
        String filePath = new File("").getAbsolutePath();
        return filePath + "/Databases/project2db.mdb";
    }

    // Get the ResultSet of the given query
    public static ResultSet getDataSet(String query, String location) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + location);
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // Use GetDataSet to get a Dataset of all stored data of a given user and then filter out the given column
    // And returns this as String
    public static String getData(String column, String user) {
        ResultSet rs = getDataSet(String.format("SELECT * FROM [Users] WHERE UserName = \"%s\"", user), getDatabasePath());
        String data = null;
        try {
            while (rs.next()) {
                data = rs.getString(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    // Set data of a given column to the given data for the given user
    public static void setData(String column, String data, String user){
        try{
            String query = String.format("UPDATE [Users] SET %s = \"%s\" WHERE UserName = \"%s\"", column, data, user);
            runQuery(query, getDatabasePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Run a query in the database
    public static void runQuery(String query, String location) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + location);
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
