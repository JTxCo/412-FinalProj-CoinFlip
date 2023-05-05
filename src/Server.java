import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    GameLogic gameLogic;
    DoQueries doQueries;
    ServerSocket serverSocket;
    private ObjectInputStream inStream = null;
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
        // start the server
        try {
            serverSocket.setReuseAddress(true);
            while (true) {
                Socket conn = serverSocket.accept();
                System.out.println("Connection established");
                ClientConnection clientConnection = new ClientConnection(conn);
                new Thread(clientConnection).start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (serverSocket != null)
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    }

    private class ClientConnection implements Runnable {
        private Socket clientSocket;
        BufferedReader bufferedReader;
        PrintWriter printWriter;

        public ClientConnection(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            Object line = null;
            try {
                inStream = new ObjectInputStream(clientSocket.getInputStream());
                try {
                    Item item = (Item) inStream.readObject();
                    System.out.println("server> object recieved: "+item);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }


//                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                printWriter = new PrintWriter(clientSocket.getOutputStream());
//                while((line = bufferedReader.readLine()) != null ){
//                    System.out.println("Server received: " + line);
//                    printWriter.println(gameLogic.flipCoin());
//                    printWriter.flush();
//                    printWriter.println(gameLogic.compareBet(line));
//                    printWriter.flush();
//                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void lineFunnel(String line) {

        switch (line) {
            case "Heads":
                System.out.println("Heads");
                break;
            case "Tails":
                System.out.println("Tails");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}
