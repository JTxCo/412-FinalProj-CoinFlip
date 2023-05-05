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
            Item item;  
            try {
                while(true){
                    printWriter = new PrintWriter(clientSocket.getOutputStream());
                    inStream = new ObjectInputStream(clientSocket.getInputStream());
                    item = (Item) inStream.readObject();
                    System.out.println("server> object recieved: "+item);
                    printWriter.println(lineFunnel(item));
                    printWriter.flush();
                }

                }catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e){
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        public String lineFunnel(Item item) {
            String winLose = "";
            switch (item.getBet()){
                case "Heads":
                    gameLogic.flipCoin();
                    winLose = gameLogic.compareBet("Heads");
                    doQueries.determineUpdate(item.getUsername(), winLose );
                    System.out.println("winLose: "+winLose);
                    return winLose;
                case "Tails":
                    gameLogic.flipCoin();
                    winLose = gameLogic.compareBet("Tails");
                    doQueries.determineUpdate(item.getUsername(), winLose);
                    System.out.println("winLose: "+winLose);
                    return winLose;
                case "NewUser":
                    Boolean isTaken = doQueries.isUsernameTaken(item.getUsername());
                    doQueries.InitializeUser(item.getUsername(), item.getPassword());
                    if(isTaken){
                        return "Username is taken";
                    }
                    else{
                        return "NewUser";
                    }
                case "OldUser":
                    int result = doQueries.verifyUser(item.getUsername(), item.getPassword());
                    switch(result){
                        case 0: return "user does not exist";
                        case 1: return "password does not match";
                        case 2: return "user exists and password matches";
                    }  
                case "TopThree":
                    printWriter.println(doQueries.getTopDudes());
                    printWriter.flush();
                    return "TopThree";
                default:
                    System.out.println("Invalid input");
                    break;
            }
            return winLose;
        }
    }

    
}
