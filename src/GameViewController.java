import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameViewController {
    private GameView gameView;
    public GameViewController() {
        // Create a new instance of the class
        // and call the method
        gameView = new GameView();
        gameView.setPlayButtonActionListener(new PlayButtonActionListener());

    }

    public class PlayButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameView.getHeadsButton().isSelected()){
                System.out.println("Heads button selected!");
            }
            else if(gameView.getTailsButton().isSelected()){
                System.out.println("Tails button selected!");
            }
            else {
                System.out.println("Please select a button");
            }
        }
    }

    public String getPlayInput() {
        return gameView.getPlayInput();
    }

}
