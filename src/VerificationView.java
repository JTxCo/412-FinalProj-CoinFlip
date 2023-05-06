import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VerificationView {
    JLabel instructions;
    JTextField userTextField;
    JTextField passwordTextField;
    JButton submitButton;
    JFrame frame;
    JLabel uniqueError;
    JLabel perror;
    JLabel eerror;

    public VerificationView() {
        frame = new JFrame();
        JPanel mainPanel = makePanel();
        frame.add(mainPanel);

        frame.setSize(400,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    public JPanel makePanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        instructions = new JLabel("Enter login information: ");
        panel.add(instructions);

        userTextField = new JTextField();
        panel.add(userTextField);

        passwordTextField = new JTextField();
        panel.add(passwordTextField);

        submitButton = new JButton("Submit!");
        panel.add(submitButton);

        perror = new JLabel("password does not match");
        eerror = new JLabel("user does not exist");
        uniqueError = new JLabel("Create a username that doesn't already exist");

        panel.add(perror);
        perror.setVisible(false);
        panel.add(eerror);
        eerror.setVisible(false);
        panel.add(uniqueError);
        uniqueError.setVisible(false);


        return panel;
    }



    public void makePasswordPanelVisible(){
        perror.setVisible(true);
        eerror.setVisible(false);

    }

    public void makeUniqueErrorVisible(){
        perror.setVisible(false);
        eerror.setVisible(false);
        uniqueError.setVisible(true);
    }



    public void makeExistPanelVisible(){
        eerror.setVisible(true);
        perror.setVisible(false);

    }

    public void switchViews(){
        frame.dispose();
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setSubmitButtonActionListener(ActionListener aL){submitButton.addActionListener(aL);}

}
