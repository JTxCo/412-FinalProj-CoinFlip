public class ClientController {
    private Model model;
    private VerificationController verificationController;
    private InitialController initialController;
    private GameViewController gameViewController;
    private void createClientController() {
        model = new Model();
        verificationController = new VerificationController();
        initialController = new InitialController();
        gameViewController = new GameViewController();
    }

    public String getPlayInput() {
        return gameViewController.getPlayInput();
    }
}
