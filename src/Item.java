import java.io.Serializable;

public class Item implements Serializable{
    private String username;

    private String bet;
    private String password;
    private int BetAmount;
    public Item(String username, String password, String bet, int BetAmount){
        this.username=username;
        this.bet=bet;
        this.password = password; 
        this.BetAmount = BetAmount;
    }

    public void setBet(String bet) {
        this.bet = bet;
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
    public int getBetAmount(){
        return BetAmount;
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
