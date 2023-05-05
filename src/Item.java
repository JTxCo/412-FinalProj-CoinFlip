import java.io.Serializable;

public class Item implements Serializable{
    private String username;
    private String bet;
    private String password;

    public Item(String username, String bet, String password){
        this.username=username;
        this.bet=bet;
        this.password = password; 
    }

    public String getUsername() {
        return username;
    }

    public String getBet() {
        return bet;
    }
    public String getPassword(){
        return password;
    }
    public String toString() {
        return "Username = " + getUsername() + " ; Bet = " + getBet();
    }

    //sending: 
    /*
     * Heads
     * Tails
     * NewUser
     * OldUser:         case 0: return "user does not exist";
                        case 1: return "password does not match";
                        case 2: return "user exists and password matches";
     * 
     * 
     * 
     */


}
