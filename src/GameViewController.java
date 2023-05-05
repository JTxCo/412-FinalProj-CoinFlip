import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class GameViewController {
    private GameView gameView;
    private String playInput="";
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    private Socket socket;
    public GameViewController() {
        // Create a new instance of the class
        // and call the method
//        gameView = new GameView();
//        gameView.setPlayButtonActionListener(new PlayButtonActionListener());

    }

    public GameViewController(Socket s) {
        // Create a new instance of the class
        // and call the method
        socket = s;
        gameView = new GameView();
        gameView.setPlayButtonActionListener(new PlayButtonActionListener());
        //gameView.setBetButtonActionListener(new BetButtonActionListener());

    }

    public class PlayButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("play button");
            // outputStream = new ObjectOutputStream(socket.getOutputStream());

            if (gameView.getHeadsButton().isSelected()){
                System.out.println("Heads button selected!");
                playInput="Heads"; //change to setPlayInput (will create method)
//                try {
//                    //socket = new Socket("localhost", 5001);
////                    BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
////                    PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
////                    System.out.println("client> sent to server: "+playInput);
////                    socketWriter.println(playInput);
////                    socketWriter.flush();
////                    String retval = socketReader.readLine();
////                    System.out.println("client> recieved result from server coin flip: "+retval);
////                    String betResult = socketReader.readLine();
////                    System.out.println("client> bet result: "+betResult);
//
////                    outputStream = new ObjectOutputStream(socket.getOutputStream());
////                    Item item = new Item("username1",playInput);
////                    System.out.println("Object written: "+item);
////                    outputStream.writeObject(item);
//
//
//
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }

            }
            else if(gameView.getTailsButton().isSelected()){
                System.out.println("Tails button selected!");
                playInput="Tails";
//                try {
////                    BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
////                    PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
////                    System.out.println("client> sent to server: "+playInput);
////                    socketWriter.println(playInput);
////                    socketWriter.flush();
////                    String retval = socketReader.readLine();
////                    System.out.println("client> recieved result from server coin flip: "+retval);
////                    String betResult = socketReader.readLine();
////                    System.out.println("client> bet result: "+betResult);
//
//
////                    outputStream = new ObjectOutputStream(socket.getOutputStream());
////                    Item item = new Item("username1",playInput);
////                    System.out.println("Object written: "+item);
////                    outputStream.writeObject(item);
//>>>>>>> allisonBranch
//
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
            }
            else {
                System.out.println("Please select a button");
            }
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
