package Lesson6.Task3;

import java.sql.*;

public class MainClass {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        connect();
        disconnect();
    }

    public static void addNewPersonAndScore(String name, int rate){
        try {
            stmt.executeUpdate("INSERT INTO STUDENTS ( NAME, RATING ) VALUES ( '"+ name +"', '"+ rate +"' );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewPerson(String name){
        try {
            stmt.executeUpdate("INSERT INTO STUDENTS ( NAME ) VALUES ( '"+ name +"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addScoreByName(String name, int rate){
        if(!proofExist(name)) try {
            throw new SQLException("Такого студента в базе не найдено!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate(" INSERT INTO STUDENTS  (RATING = '"+ rate +"' WHERE NAME = '"+ name +"' );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateScoreByName(String name, int rate){
        if(!proofExist(name)) try {
            throw new SQLException("Такого студента в базе не найдено!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate("UPDATE STUDENTS SET SCORE = '"+rate+"' WHERE NAME ='"+name+"' ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int readScoreByName(String name){
        int score = Integer.parseInt(null);
        if(!proofExist(name)) try {
            throw new SQLException("Такого студента в базе не найдено!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS WHERE NAME = '" + name + "';");
            score = Integer.parseInt(rs.getString("SCORE"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return score;
    }

    public static void readNamesByScore(int rate){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS WHERE RATING = '" + rate + "';");
            while (rs.next()) {
                System.out.println("Студент: " + rs.getString("NAME") + "; Балл: " + rate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean proofExist(String name){ //проверяет существует ли соответствующая запись в БД
        int i = 0;
        try{
            ResultSet rs =stmt.executeQuery("SELECT * FROM STUDENTS WHERE NAME = '" + name + "';");
            while(rs.next()){
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (i!=0)?false:true;
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
