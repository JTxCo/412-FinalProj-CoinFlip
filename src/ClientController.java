import java.net.Socket;

public class ClientController {
    private Model model;
    private VerificationController verificationController;
    private InitialController initialController;
    private GameViewController gameViewController;
    public ClientController() {
    }

    public ClientController(Socket s) {
        Socket socket = s;
        model = new Model();
        initialController = new InitialController(socket);
    }
}
