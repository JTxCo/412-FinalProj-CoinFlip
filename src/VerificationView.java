import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VerificationView {
    JLabel instructions;
    JTextField userTextField;
    JTextField passwordTextField;
    JButton submitButton;

    JFrame frame;

    public VerificationView() {
        // Create a new instance of the class
        // and call the method
        System.out.println("verification view constructor");
        frame = new JFrame();
        frame.add(makePanel());

        frame.setSize(400,400);
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

        return panel;
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setSubmitButtonActionListener(ActionListener aL){submitButton.addActionListener(aL);}

}
