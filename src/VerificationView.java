import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VerificationView {
    JLabel instructions;
    JTextField userTextField;
    JTextField passwordTextField;
    JButton submitButton;

    JFrame frame;
    JPanel pPanel;
    JPanel ePanel;

    JLabel perror;
    JLabel eerror;

    public VerificationView() {
        // Create a new instance of the class
        // and call the method
        System.out.println("verification view constructor");
        frame = new JFrame();
        frame.add(makePanel());

//        pPanel = passwordPanel();
//        frame.add(pPanel);
//        pPanel.setVisible(false);
//
//        ePanel = existPanel();
//        frame.add(ePanel);
//        ePanel.setVisible(false);



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

        perror = new JLabel("password does not match");
        eerror = new JLabel("user does not exist");

        panel.add(perror);
        perror.setVisible(false);
        panel.add(eerror);
        eerror.setVisible(false);

//        submitButton.addActionListener(e -> {
//            frame.dispose();
//        });

        return panel;
    }

//    public JPanel passwordPanel(){
//        JPanel pPanel = new JPanel();
//        pPanel.setLayout(new BoxLayout(pPanel,BoxLayout.Y_AXIS));
//        JLabel error = new JLabel("password does not match");
//        pPanel.add(error);
//
//        return pPanel;
//
//    }

    public void makePasswordPanelVisible(){
//        pPanel.setVisible(true);
        perror.setVisible(true);

    }


//    public JPanel existPanel(){
//        JPanel ePanel = new JPanel();
//        ePanel.setLayout(new BoxLayout(ePanel,BoxLayout.Y_AXIS));
//        JLabel error = new JLabel("user does not exist");
//        ePanel.add(error);
//
//        return ePanel;
//
//    }

    public void makeExistPanelVisible(){
//        ePanel.setVisible(true);
        eerror.setVisible(true);

    }

    public void switchViews(){
        submitButton.addActionListener(e -> {
            frame.dispose();
        });
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setSubmitButtonActionListener(ActionListener aL){submitButton.addActionListener(aL);}

}
