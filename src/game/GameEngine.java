package game;

public class GameEngine {

	public Player player;
	private GameController controller;
	private ConsoleView view;
	private String gameMode;
	
	public GameEngine(ConsoleView cv, GameController gc) {
		player = new Player();
		controller = gc;
		view = cv;
	}
	
	public GameEngine() {
		player = new Player();
	}

	public void run() {
		view.showWelcomeMessage();
		this.gameMode = view.askUserWhichPlayModeIsWanted();
		while (!(gameMode.equals("1") || gameMode.equals("2"))) {
			this.gameMode = view.askUserWhichPlayModeIsWanted();
		}
		controller.defineGameMode(Integer.parseInt(gameMode));
	}
	
	public void askGameInitiatingQuestions() {
		
	}
	

}
