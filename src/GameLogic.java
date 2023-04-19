public class GameLogic {
    int rand;
    String result;
    public GameLogic() {
        FlipCoin();
        DisplayResult();
        // Create a new instance of the class
        // and call the method

    }
    //create a function that flips a coin and returns the result
    //not returning anything at the momment
    public void FlipCoin(){
        rand = (int)(Math.random())*10;
        rand = rand%2;
        if (rand==0){
            result = "Heads";
        }
        else {
            result = "Tails";
        }

    }
    public void DisplayResult(){
        System.out.println("Result: "+result);
    }
}
