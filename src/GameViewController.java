import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class GameViewController {
    private GameView gameView;
    private String playInput="";
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inStream;
    private BufferedReader socketReader;
    private Socket socket;
    private Item item;
    public GameViewController() {
        // Create a new instance of the class
        // and call the method
//        gameView = new GameView();
//        gameView.setPlayButtonActionListener(new PlayButtonActionListener());

    }
    public void leadersBoard(){
        try {
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            item.setBet("TopThree");
            System.out.println("Object written: "+item);
            outputStream.writeObject(item);
            String retval = socketReader.readLine();
            
            String[] entries = retval.replaceAll("[^,=a-zA-Z\\d]", "").split(",");
            System.out.println("client> recieved from server: "+retval);
            String username1 = entries[0].split("=")[0];
            String balance1 = entries[0].split("=")[1];
            String username2 = entries[1].split("=")[0];
            String balance2 = entries[1].split("=")[1];
            String username3 = entries[2].split("=")[0];
            String balance3 = entries[2].split("=")[1];
            System.out.println("username1: "+username1+" balance1: "+balance1);
            System.out.println("username2: "+username2+" balance2: "+balance2);
            System.out.println("username3: "+username3+" balance3: "+balance3);
            gameView.setUser1(username1,Integer.parseInt(balance1));
            gameView.setUser2(username2,Integer.parseInt(balance2));
            gameView.setUser3(username3,Integer.parseInt(balance3));
        } catch(IOException ex){
            throw new RuntimeException(ex);
        }
    }
    public GameViewController(Socket s, Item i) {
        // Create a new instance of the class
        // and call the method
        socket = s;
        item = i;
        gameView = new GameView();
        leadersBoard();
        gameView.setPlayButtonActionListener(new PlayButtonActionListener());
        //gameView.setBetButtonActionListener(new BetButtonActionListener());

    }

    public class PlayButtonActionListener implements ActionListener {
        
        

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("play button");

             //reader from server

            

            // outputStream = new ObjectOutputStream(socket.getOutputStream());

            if (gameView.getHeadsButton().isSelected()){
                System.out.println("Heads button selected!");
                //playInput="Heads"; //change to setPlayInput (will create method)
                //BufferedReader socketReader = null; //reader from server
                try {
                    socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    item.setBet("Heads");
                    System.out.println("Object written: "+item);
                    outputStream.writeObject(item);

                    String retval = socketReader.readLine();
                    System.out.println("client> recieved from server: "+retval);
                    gameView.setGamestatus(retval);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
//                try {
//                    //socket = new Socket("localhost", 5001);
//                    BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
//                    System.out.println("client> sent to server: "+playInput);
//                    socketWriter.println(playInput);
//                    socketWriter.flush();
//                    String retval = socketReader.readLine();
//                    System.out.println("client> recieved result from server coin flip: "+retval);
//                    String betResult = socketReader.readLine();
//                    System.out.println("client> bet result: "+betResult);
////
//////                    outputStream = new ObjectOutputStream(socket.getOutputStream());
//////                    Item item = new Item("username1",playInput);
//////                    System.out.println("Object written: "+item);
//////                    outputStream.writeObject(item);
////
////
////
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }

            }
            else if(gameView.getTailsButton().isSelected()){
                System.out.println("Tails button selected!");
                //playInput="Tails";

                try {
                    socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    item.setBet("Tails");
                    System.out.println("Object written: "+item);
                    outputStream.writeObject(item);

                    String retval = socketReader.readLine();
                    System.out.println("client> recieved from server: "+retval);
                    gameView.setGamestatus(retval);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
//                try {
//                    BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
//                    System.out.println("client> sent to server: "+playInput);
//                    socketWriter.println(playInput);
//                    socketWriter.flush();
//                    String retval = socketReader.readLine();
//                    System.out.println("client> recieved result from server coin flip: "+retval);
//                    String betResult = socketReader.readLine();
//                    System.out.println("client> bet result: "+betResult);
////
////
//////                    outputStream = new ObjectOutputStream(socket.getOutputStream());
//////                    Item item = new Item("username1",playInput);
//////                    System.out.println("Object written: "+item);
//////                    outputStream.writeObject(item);
////>>>>>>> allisonBranch
////
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
            }
            else {
                System.out.println("Please select a button");
            }
            leadersBoard();
        }
    }

    public class BetButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Double betInput = Double.parseDouble(gameView.getBetTextField().getText());
            System.out.println("Bet amount entered: "+betInput);

        }
    }

    public String getPlayInput() {
        //return gameView.getPlayInput();
        return playInput;
    }

}
