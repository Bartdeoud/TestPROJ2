package Handlers;

import java.sql.*;

public class DataHandler
{
    private final String location;

    public DataHandler(String location){
        this.location = location;
    }

    public ResultSet getData(String query){
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + location);
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    public void runQuery(String query){
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + location);
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
