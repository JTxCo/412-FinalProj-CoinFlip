import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    GameLogic gameLogic;
    DoQueries doQueries;
    ServerSocket serverSocket;
    public static void main(String[] args) {
        new Server().createServer();
    }
    public void createServer() {
        gameLogic = new GameLogic();
        doQueries = new DoQueries();
        try {
            serverSocket = new ServerSocket(5001);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //start the server
        try {
            serverSocket.setReuseAddress(true);
            while(true){
                Socket conn = serverSocket.accept();
                System.out.println("Connection established");
                ClientConnection clientConnection = new ClientConnection(conn);
                new Thread(clientConnection).start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(serverSocket != null)
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    }
    private class ClientConnection implements Runnable{
        private Socket clientSocket;
        BufferedReader bufferedReader;
        PrintWriter printWriter;    
       public  ClientConnection(Socket clientSocket){
            this.clientSocket = clientSocket;
        }
        @Override
        public void run(){
            String line;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                printWriter = new PrintWriter(clientSocket.getOutputStream());
                while((line = bufferedReader.readLine()) != null ){
                    System.out.println("Server received: " + line);
                    printWriter.println(gameLogic.flipCoin());
                    printWriter.flush();
                    printWriter.println(gameLogic.compareBet(line));
                    printWriter.flush();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
    }

}






