public class Server {
    GameLogic gameLogic;
    DoQueries doQueries;
    public static void main(String[] args) {
        new Server().createServer();
    }
    public void createServer() {
        gameLogic = new GameLogic();
        doQueries = new DoQueries();
    }
}
