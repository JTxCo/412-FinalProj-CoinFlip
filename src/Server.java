import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    GameLogic gameLogic;
    DoQueries doQueries;
    public static void main(String[] args) {
        new Server().createServer();
    }
    public void createServer() {
        gameLogic = new GameLogic();
        doQueries = new DoQueries();


        //start the server
        try {
            ServerSocket serverSocket = new ServerSocket(5001);
            Socket conn = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
            String line;
            while((line = bufferedReader.readLine()) != null ){
                System.out.println("Server received: " + line);
                printWriter.println(gameLogic.FlipCoin());
                printWriter.flush();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
