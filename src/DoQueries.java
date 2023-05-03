import javax.swing.*;
import java.sql.*;
public class DoQueries {
    private Connection StartConn;
    public DoQueries() {
           // Create a new instance of the class
        // and call the method
        try { 
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        makeConnection();
        showData();
    }

    public void makeConnection() {//this connects or makes the database
        try {
            System.out.println("Connecting to database...");
            StartConn = DriverManager.getConnection("jdbc:sqlite: coinflipDB.db");
            String cmd = "CREATE TABLE IF NOT EXISTS coinflipData(" +
                    "username STRING PRIMARY KEY," +
                    "password STRING," +
                    "accountBalance INTEGER);";
            StartConn.createStatement().executeUpdate(cmd);
            StartConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connection to database established.");
    }   
    public void showData(){
        try {
            System.out.println("Testing connection to database... doing test query.");
            Connection conn = DriverManager.getConnection("jdbc:sqlite: coinflipDB.db");
            String cmd = "SELECT * FROM coinflipData;";
            ResultSet rs = conn.createStatement().executeQuery(cmd);
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                int accountBalance = rs.getInt("accountBalance");
                String s = String.format("%3s %10s %3d", username, password, accountBalance);
                System.out.println(s);
            }
            System.out.println("Test query successful.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    } 
    public void UpdateBalance(){ }; // Update the balance of the user
    public void InitializeUser(String username, String password, int accountBalance){
        System.out.println("Initializing user...");
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite: coinflipDB.db");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO coinflipData (username, password, accountBalance) VALUES (?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, accountBalance);
            ps.close();
            ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.format("User initialized as: %s %s %d.", username, password, accountBalance);
    }; // Initialize the user
    public void verifyUser(){}; // Verify the user
    public Boolean isUsernameTaken(){
        return true;
    }; // Check if the username is taken

}
