package org.example;

/**
 * Hello world!
 *
 */
import java.sql.SQLException;
public class App
{
    public static void main(String[] args) {
        try {
            DBConnection db = DBConnection.getInstance();
            // Insert
            Task t = new Task("Publish code on GitHub", true, "Abubaker Mohammed");
            t.insertTask();
            // Retrieve all tasks
            t.retrieveTasks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}