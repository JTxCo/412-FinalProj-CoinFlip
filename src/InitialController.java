import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class InitialController {
    private InitialView initialView;
    private boolean isNew;
    private Socket socket;
    public InitialController(){
        //default
    }
    public InitialController(Socket s) {
        socket = s;
        // Create a new instance of the class
        // and call the method
        initialView = new InitialView();
        initialView.setNewButtonActionListener(new NewButtonActionListener());
        initialView.setReturnButtonActionListener(new ReturnButtonActionListener());

    }

    public class NewButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("new button");
            isNew = true;
            VerificationController verificationController = new VerificationController(isNew,socket);
        }
    }

    public class ReturnButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("return button");
            isNew = false;
            VerificationController verificationController = new VerificationController(isNew,socket);
        }
    }
}
