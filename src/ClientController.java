import java.net.Socket;

public class ClientController {
    private Model model;
    private VerificationController verificationController;
    private InitialController initialController;
    private GameViewController gameViewController;
    public ClientController() {
//        model = new Model();
//        verificationController = new VerificationController();
//        initialController = new InitialController();
//        gameViewController = new GameViewController();
    }

    public ClientController(Socket s) {
        Socket socket = s;
        model = new Model();
        //verificationController = new VerificationController();
        initialController = new InitialController(socket);
        //gameViewController = new GameViewController(socket);
    }

//    public String getPlayInput() {
//        String result = gameViewController.getPlayInput();
//        System.out.println("clientController input: "+result);
//        return result;
//    }
}
