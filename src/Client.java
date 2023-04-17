public class Client {
    ClientController clientController;
    public static void main(String[] args) {
        // Create a new instance of the class
        // and call the method
        new Client().createController();
    }
    void createController(){
        clientController = new ClientController();
    };
}
