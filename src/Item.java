import java.io.Serializable;

public class Item implements Serializable{
    private String username;
    private String bet;

    public Item(String username, String bet){
        this.username=username;
        this.bet=bet;
    }

    public String getUsername() {
        return username;
    }

    public String getBet() {
        return bet;
    }

    public String toString() {
        return "Username = " + getUsername() + " ; Bet = " + getBet();
    }
}
