package Handlers;

import static Handlers.DatabaseHandler.*;

public class Login
{
    // Initialize variables
    public static String loggedInUser;
    public static int accessLevel;
    public static String user;

    // Returns if password is correct
    public static boolean loginPasswordCheck(String user, String password){
        return getData("Password", user).equals(password);
    }

    // Sets the current logged in user
    public static void setLoggedInUser(String username){
        user = username;
    }

    // Gets the current logged in user
    public static String getLoggedInUser(){
        return user;
    }

}
