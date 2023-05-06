import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class Client {
    ClientController clientController;
    Socket socket;

    public static void main(String[] args) {
        new Client().createController();
    }

    void createController() {
        clientController = new ClientController();

        try {
            socket = new Socket("localhost", 5001);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clientController = new ClientController(socket);


    };
}
