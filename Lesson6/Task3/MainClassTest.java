package Lesson6.Task3;

import org.junit.*;

import java.sql.*;

public class MainClassTest {
    private static Connection connection;
    private static Statement stmt;
    private static Savepoint sp;

    @BeforeClass
    public static void init(){
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:db.db");
                stmt = connection.createStatement();
                connection.setAutoCommit(false);
                sp = connection.setSavepoint("A");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }



    @AfterClass
        public static void close(){
            try {
                connection.rollback(sp);
                connection.commit();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    @Test
    public void addNewPersonAndScore() {
        String name = "Пупкин";
        int rate = 5;
        try {
            stmt.executeUpdate("INSERT INTO univer ( NAME, SCORE ) VALUES ( '"+ name +"', '"+ rate +"' );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addNewPerson() {
    }

    @Test
    public void addScoreByName() {
    }

    @Test
    public void updateScoreByName() {
    }

    @Test
    public void readScoreByName() {
    }

    @Test
    public void readNamesByScore() {
    }

    @Test
    public void proofExist() {
    }
}