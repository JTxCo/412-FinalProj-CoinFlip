import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
            BufferedReader socketReader = null; //reader from server
            try {
                socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            if(isNew){
                try {
                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    Item item = new Item(verificationView.getUserTextField().getText(),verificationView.getPasswordTextField().getText(),"NewUser",0);
                    System.out.println("Object written: "+item);
                    outputStream.writeObject(item);


                    String retval = socketReader.readLine();
                    System.out.println("client> recieved from server: "+retval);

                    GameViewController gameViewController = new GameViewController(socket,item);
                    verificationView.switchViews();

//                    if(retval.equals("Username is taken")){
//                        verificationView.makeUniqueErrorVisible();
//                    }
//                    else{
//                        GameViewController gameViewController = new GameViewController(socket,item);
//                        verificationView.switchViews();
//                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else {
                try {
                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    
                    Item item = new Item(verificationView.getUserTextField().getText(),verificationView.getPasswordTextField().getText(),"OldUser",0);

                    System.out.println("Object written: "+item);
                    outputStream.writeObject(item);

                    String retval = socketReader.readLine();

                    System.out.println("client> recieved from server: "+retval);

                    if(retval.equals("password does not match")){
                        verificationView.makePasswordPanelVisible();
                    }
                    else if(retval.equals("user does not exist")){
                        verificationView.makeExistPanelVisible();
                    }
                    else if(retval.equals("user exists and password matches")){
                        verificationView.switchViews();
                        GameViewController gameViewController = new GameViewController(socket,item);
                    }

//                    String betResult = socketReader.readLine();
//                    System.out.println("client> bet result: "+betResult);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }



        }
    }
}
