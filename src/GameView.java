import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameView {
    private String playInput;
    JFrame frame;
    JPanel panel;
    JButton playButton;
    JRadioButton headsButton;
    JRadioButton tailsButton;
    JTextField betTextField;
    JButton betButton;
    JLabel gameStatus;
    JLabel user1;
    JLabel user2;
    JLabel user3;
    public GameView() {
        //makePlaySelection();

        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(BorderLayout.SOUTH,makePlaySelection());
        //panel.add(BorderLayout.EAST,makeBettingSection());
        panel.add(BorderLayout.CENTER,makeLeaderBoard());
        panel.add(BorderLayout.NORTH,makeMiddleSection());

        // Create a new instance of the class
        // and call the method
        //makeBettingSection();
        frame.add(BorderLayout.CENTER,panel);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public JPanel makeLeaderBoard(){
        JPanel leaderboardPanel = new JPanel();
        leaderboardPanel.setLayout(new BoxLayout(leaderboardPanel,BoxLayout.Y_AXIS));

        JLabel leaderboard = new JLabel("Leaderboard");
         user1 = new JLabel("Insert user from array");
         user2 = new JLabel("Insert user from array");
         user3 = new JLabel("Insert user from array");

        leaderboardPanel.add(leaderboard);
        leaderboardPanel.add(user1);
        leaderboardPanel.add(user2);
        leaderboardPanel.add(user3);

        return leaderboardPanel;
    }
    public JTextField getBetTextField() {
        return betTextField;
    }

    public JPanel makeBettingSection(){
        JPanel betSelectionPanel = new JPanel();
        betSelectionPanel.setLayout(new BoxLayout(betSelectionPanel,BoxLayout.Y_AXIS));
        JLabel instructions = new JLabel("Enter Bet: ");
        betTextField = new JTextField(10);
        betButton = new JButton("Go!");

        betSelectionPanel.add(instructions);
        betSelectionPanel.add(betTextField);
        betSelectionPanel.add(betButton);

        return betSelectionPanel;

    }
    public JPanel makeMiddleSection(){
        JPanel middleSection = new JPanel();
        middleSection.setLayout(new BoxLayout(middleSection,BoxLayout.Y_AXIS));
        middleSection.add(makeBigLabel());
        middleSection.add(makeGameStatus());
        return middleSection;
    }
    public JPanel makeBigLabel(){
        JPanel bigLabelPanel = new JPanel();
        JLabel bigLabel = new JLabel("Coin Flip!");
        Font font = bigLabel.getFont();
        bigLabel.setFont(font.deriveFont(font.getSize() + 50f));
        bigLabelPanel.add(bigLabel);
        return bigLabelPanel;
    }
    public JPanel makeGameStatus(){
        JPanel gameStatusPanel = new JPanel();
        JLabel title = new JLabel("Game Status: ");
        gameStatus = new JLabel(" ", SwingConstants.CENTER);
        gameStatusPanel.add(title);
        gameStatusPanel.add(gameStatus);
        return gameStatusPanel;
    }
    public void setBetButtonActionListener(ActionListener aL){betButton.addActionListener(aL);
    }
    public void makeCoinLabel(){}
    public void makeInstructionLabel(){}

    public String getPlayInput() {
        return playInput;
    }

    public JRadioButton getHeadsButton() {
        return headsButton;
    }

    public JRadioButton getTailsButton() {
        return tailsButton;
    }

    public JPanel makePlaySelection(){
        JPanel playSelectionPanel = new JPanel();
        JLabel instructions = new JLabel("instructions here for playing");
        playSelectionPanel.add(instructions);

        headsButton = new JRadioButton();
        headsButton.setText("Heads");
        playSelectionPanel.add(headsButton);
        tailsButton = new JRadioButton();
        tailsButton.setText("Tails");
        playSelectionPanel.add(tailsButton);

        ButtonGroup group = new ButtonGroup();
        group.add(headsButton);
        group.add(tailsButton);

        playButton = new JButton("Play!");
        playSelectionPanel.add(playButton);


        return playSelectionPanel;
    }

    public void setPlayButtonActionListener(ActionListener aL){playButton.addActionListener(aL);
    }
    public void setGamestatus(String s){
        gameStatus.setText(s);
    }
 
    public void setUser1(String s, int i){
        String string = s+" "+i;
        user1.setText(string);
    }
    public void setUser2(String s, int i){
        String string = s+" "+i;
        user2.setText(string);
    }
    public void setUser3(String s, int i){
        String string = s+" "+i;
        user3.setText(string);
    }

}
