import java.net.Socket;

public class ClientController {
    //private Model model;
    private InitialController initialController;
    public ClientController() {
    }

    public ClientController(Socket s) {
        Socket socket = s;
        //model = new Model();
        initialController = new InitialController(socket);
    }

}
