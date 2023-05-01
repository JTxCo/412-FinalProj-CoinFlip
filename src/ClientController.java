public class ClientController {
    private Model model;
    private VerificationController verificationController;
    private InitialController initialController;
    private GameViewController gameViewController;
    public ClientController() {
        model = new Model();
        verificationController = new VerificationController();
        initialController = new InitialController();
        gameViewController = new GameViewController();
    }

    public String getPlayInput() {
        String result = gameViewController.getPlayInput();
        System.out.println("clientController input: "+result);
        return result;
    }
}
