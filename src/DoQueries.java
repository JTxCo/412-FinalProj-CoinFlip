import javax.swing.*;
import java.sql.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
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
    public void UpdateBalance(String username, int newBalance){ 
        Connection conn;
        try{
            String s = "Updating balance for user: " + username + " to " + newBalance;
            System.out.println(s);
            conn = DriverManager.getConnection("jdbc:sqlite: coinflipDB.db");
            PreparedStatement ps = conn.prepareStatement("UPDATE coinflipData SET accountBalance = ? WHERE username = ?");
            ps.setInt(1, newBalance);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();
            conn.close();
            s = " Balance updated for user: " + username + " to " + newBalance;
            System.out.println(s);
        }catch(SQLException e){
            e.printStackTrace();
        }

    }; // Update the balance of the user
    public void InitializeUser(String username, String password, int accountBalance){
        System.out.println("Initializing user...");
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite: coinflipDB.db");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO coinflipData (username, password, accountBalance) VALUES (?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, accountBalance);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.format("User initialized as: %s %s %d.", username, password, accountBalance);
    }; // Initialize the user
    public void verifyUser( String username, String password){
        System.out.println("Verifying user...");
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite: coinflipDB.db");
            PreparedStatement ps = conn.prepareStatement("SELECT CASE WHEN EXISTS (SELECT 1 FROM coinflipData WHERE username = ? AND password = ?) THEN 2 WHEN EXISTS (SELECT 1 FROM coinflipData WHERE username = ?) THEN 1 ELSE 0 END");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, username);
            ResultSet rs = ps.executeQuery();
            int i = rs.getInt(1);
            switch (i) {
                case 0:
                    System.out.println("User with username " + username + " does not exist.");
                    break;
                case 1:
                    System.out.println("User with username " + username + " exists but password is not a match.");
                    break;
                case 2:
                    System.out.println("User with username " + username + " exists and password is a match.");
                    break;
                default:
                    System.out.println("Unknown result: " + i);
                    break;
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }; // Verify the user
    public Boolean isUsernameTaken(String userName){
        Connection conn; 
        PreparedStatement ps;
        System.out.println("Checking if username is taken...");
        try {
            conn = DriverManager.getConnection("jdbc:sqlite: coinflipDB.db");
            ps = conn.prepareStatement("SELECT * FROM coinflipData WHERE username = ?");
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            ps.close();
            conn.close();
            if(rs.next()){
                System.out.format("Username: %s is taken.\n", userName);
                return true;
            }
            else{
                System.out.format("Username: %s is not taken.\n", userName);
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            System.out.println("Username check complete.");
        }
        
        return false;
    }; // Check if the username is taken
    public ArrayList getTopDudes(){
        Connection conn;
        PreparedStatement ps;
        System.out.println("Getting top dudes...");
        try{
            conn = DriverManager.getConnection("jdbc:sqlite: coinflipDB.db");
            ps = conn.prepareStatement("SELECT username, accountBalance FROM coinflipData ORDER BY accountBalance DESC LIMIT 3")
            ResultSet rs = ps.executeQuery();
            ArrayList<Map.Entry<String, Integer>> topDudes = new ArrayList<>();
            while(rs.next()){
                String username = rs.getString("username");
                int accountBalance = rs.getInt("accountBalance");
                Map.Entry<String, Integer> dude = new AbstractMap.SimpleEntry<>(username, accountBalance);
                topDudes.add(dude);
            }
            return topDudes;
        }catch(SQLException e){
            e.printStackTrace(); 
        }
    }
}
