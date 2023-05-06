public class GameLogic {
    int rand;
    String result;
    public GameLogic() {
        flipCoin();
        displayResult();

    }

    public String flipCoin(){
        double num = Math.random()*10;
        rand = (int)num;
        rand = rand%2;
        if (rand==0){
            result = "Heads";
        }
        else {
            result = "Tails";
        }
        return result;

    }
    public void displayResult(){
        System.out.println("Result: "+result);
    }

    public String compareBet(String bet){
        if (bet.equals(result)){
            return("Win!");
        }
        else {
            return ("Lose");
        }

    }
}
