import javax.swing.*;
import java.sql.*;
public class DoQueries {
    public DoQueries() {
           // Create a new instance of the class
        // and call the method
        String url = "jdbc:mysql://localhost:3306/coinflip";
        staString DB_DRV = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "root";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String createDB = "CREATE TABLE IF NOT EXISTS users " + "(username VARCHAR(50), " + "password VARCHAR(50), " + "balance INT(255), " + "PRIMARY KEY ( username ))";
            stmt.executeUpdate(createDB);
        System.out.println("created db");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void UpdateBalance(){
        

    }; // Update the balance of the user
    public void InitializeUser(){}; // Initialize the user
    public void verifyUser(){}; // Verify the user
    public Boolean isUsernameTaken(){
        return true;
    }; // Check if the username is taken
}
