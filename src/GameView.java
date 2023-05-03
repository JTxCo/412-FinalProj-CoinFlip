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
    public GameView() {
        //makePlaySelection();

        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(BorderLayout.SOUTH,makePlaySelection());
        // Create a new instance of the class
        // and call the method
        //makeBettingSection();
        frame.add(BorderLayout.CENTER,panel);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
    public void makeLeaderBoard(){}
    public void makeCoinAnimation(){}
    public void makeUserInfo(){}
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


        //temporary: take user input of heads/tails, will replace with radio buttons later
//        try {
//            System.out.println("Enter Heads or Tails: ");
//            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            playInput = bufferedReader.readLine();
//            System.out.println("selected: "+playInput);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        return playSelectionPanel;
    }

    public void setPlayButtonActionListener(ActionListener aL){playButton.addActionListener(aL);
    }


}
