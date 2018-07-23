package Lesson6.Task3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass {
    private static Statement stmt;
    private static Connecting connecting;

    public static void main(String[] args) {
        connecting = new Connecting();
        connecting.connect();
        //
        connecting.disconnect();
    }

    public static void addNewPersonAndScore(String name, int score){
        try {
            stmt.executeUpdate("INSERT INTO univer ( NAME, SCORE ) VALUES ( '"+ name +"', '"+ score +"' );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewPerson(String name){
        try {
            stmt.executeUpdate("INSERT INTO univer ( NAME ) VALUES ( '"+ name +"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addScoreByName(String name, int score){
        if(!proofExist(name)) try {
            throw new SQLException("Такого студента в базе не найдено!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate(" INSERT INTO univer  (SCORE = '"+ score +"' WHERE NAME = '"+ name +"' );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateScoreByName(String name, int score){
        if(!proofExist(name)) try {
            throw new SQLException("Такого студента в базе не найдено!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate("UPDATE univer SET SCORE = '"+score+"' WHERE NAME ='"+name+"' ;");
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE NAME = '" + name + "';");
            score = Integer.parseInt(rs.getString("SCORE"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return score;
    }

    public static void readNamesByScore(int score){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE SCORE = '" + score + "';");
            while (rs.next()) {
                System.out.println("Студент: " + rs.getString("NAME") + "; Балл: " + rs.getString("SCORE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean proofExist(String s){ //проверяет существует ли соответствующая запись в БД
        int i = 0;
        try{
            ResultSet rs =stmt.executeQuery("SELECT * FROM SHOP WHERE title = '" + s + "';");
            while(rs.next()){
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (i!=0)?false:true;
    }


}
