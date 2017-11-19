package game;

public class GameEngine {

	public Player player;
	private GameController controller;
	private ConsoleView view;
	private String gameMode;
	private String bet;
	private String betMultiply;
	private String targetSection;
	private double targetResult;
	private double winner;
	
	public GameEngine(ConsoleView cv, GameController gc, Player pl) {
		player = pl;
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
		this.bet = controller.validateBetInput();
		this.betMultiply = controller.validateBetTarget();
		this.targetSection = controller.validateBetTargetSection();
		this.targetResult = controller.playerTargetRange(betMultiply, targetSection);
		
	}
	
	public boolean callAndValidateForClassic() {
		askGameInitiatingQuestions();
		this.winner = controller.generateWinningNumber();
		return controller.playerWonOrLost(winner, targetResult);
	}
	
	public void playWithClassicMode() {
		view.showClassicModeStartMessage();
		if (player.getScore() > 0) {
			boolean wonOrLost = callAndValidateForClassic();
			doUserWin(wonOrLost);
			
		}
		
	}

	private void doUserWin(boolean wonOrLost) {
		// TODO Auto-generated method stub
		
	}
	

}
