package Lesson6.Task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecting {
    private static Connection connection;


    public static Connection getConnection() {
        return connection;
    }
    public Connecting() {
    }
    public static void  connect(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:db.db");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
