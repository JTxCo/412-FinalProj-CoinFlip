import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameView {
    public GameView() {
        // Create a new instance of the class
        // and call the method
        makeBettingSection();
    }
    public void makeLeaderBoard(){}
    public void makeCoinAnimation(){}
    public void makeUserInto(){}
    public void makeBettingSection(){
        //will add text field and go button here

        //temporary: take user input of bet amount, will replace with text field
        try {
            System.out.println("Enter bet amount: ");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String betInput = bufferedReader.readLine();
            System.out.println("entered: "+betInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void makeCoinLabel(){}
    public void makeInstructionLabel(){}
    public void makePlaySelection(){
        //temporary: take user input of heads/tails, will replace with radio buttons later
        try {
            System.out.println("Enter heads or tails: ");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String playInput = bufferedReader.readLine();
            System.out.println("selected: "+playInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
