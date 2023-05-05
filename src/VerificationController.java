import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class VerificationController {
    private VerificationView verificationView;
    private Socket socket;
    private boolean isNew;

    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;
    public VerificationController() {
        // Create a new instance of the class
        // and call the method

        //verificationView = new VerificationView();
    }
    public VerificationController(boolean bool,Socket s){
        socket = s;
        verificationView = new VerificationView();
        isNew = bool;
        System.out.println("verification controller activated, val of bool is "+bool);
        verificationView.setSubmitButtonActionListener(new SubmitButtonActionListener());
    }

    public class SubmitButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("submit button");

            if(isNew){
                try {
                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    Item item = new Item(verificationView.getUserTextField().getText(),verificationView.getPasswordTextField().getText(),"NewUser");
                    System.out.println("Object written: "+item);
                    outputStream.writeObject(item);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else {
                try {
                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    Item item = new Item(verificationView.getUserTextField().getText(),verificationView.getPasswordTextField().getText(),"OldUser");
                    System.out.println("Object written: "+item);
                    outputStream.writeObject(item);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }



        }
    }
}
