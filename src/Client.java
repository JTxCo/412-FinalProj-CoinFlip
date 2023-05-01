import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class Client {
    ClientController clientController;
    public static void main(String[] args) {
        // Create a new instance of the class
        // and call the method
        new Client().createController();
    }
    void createController(){
        clientController = new ClientController();
        String playInput = clientController.getPlayInput();

        //client Connecting to server
        try {
            Socket socket = new Socket("localhost", 5001);
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
            String line = "testing";
            while((line = inputReader.readLine())!=null){
                socketWriter.println(line);
                socketWriter.flush();
                String retval = socketReader.readLine();
                System.out.println(retval);
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    };
}
