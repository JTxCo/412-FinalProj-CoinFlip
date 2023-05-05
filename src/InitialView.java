import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InitialView {
    JFrame frame;
    JButton newButton;
    JButton returnButton;
    public InitialView() {
        frame = new JFrame();
        frame.add(makePrompt());

        frame.setSize(400,400);
        frame.setVisible(true);

        // Create a new instance of the class
        // and call the method
    }
    public JPanel makePrompt() {
        System.out.println("make prompt activated");
        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Are you a new or returning user?");
        newButton = new JButton("New");
        newButton.addActionListener(e -> {
            frame.dispose();
        });
        returnButton = new JButton("Returning");
        returnButton.addActionListener(e -> {
            frame.dispose();
        });

        panel.add(BorderLayout.NORTH,label);
        panel.add(BorderLayout.WEST,newButton);
        panel.add(BorderLayout.EAST,returnButton);


        return panel;
        // Create a new label that shows what the user is supposed to do
    }

    public void setNewButtonActionListener(ActionListener aL){newButton.addActionListener(aL);
    }

    public void setReturnButtonActionListener(ActionListener aL){returnButton.addActionListener(aL);
    }
}
