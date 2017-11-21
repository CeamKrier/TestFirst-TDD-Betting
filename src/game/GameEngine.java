package game;

public class GameEngine {

	public Player player;
	private GameController controller;
	private ConsoleView view;
	private String gameMode;
	public String bet;
	public String betMultiply;
	private String targetSection;
	public double targetResult;
	private double winner;
	private int parsedBetNum;
	
	public GameEngine(ConsoleView cv, GameController gc, Player pl) {
		player = pl;
		controller = gc;
		view = cv;
	}
	
	public GameEngine() {
		player = new Player();
		view = new ConsoleView(this);
		controller = new GameController(this, view, player);
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
	
	public void playWithClassicMode(String betMultiply, String bet) {
		view.showClassicModeStartMessage();
		if (player.getScore() > 0) {
			boolean wonOrLost = callAndValidateForClassic();
			doUserWin(wonOrLost, betMultiply, bet);
			
		}
		
	}

	public void doUserWin(boolean wonOrLost, String betMultiply, String bet) {
		if (wonOrLost) {
			int newScore = player.getScore() + Integer.parseInt(betMultiply) * Integer.parseInt(bet);
			player.setScore(newScore);
			view.wonMessage();
			view.rolledNumber(this.winner, this.targetResult, this.targetSection);
			view.showPlayerBalance();
		} else {
			int newScore = player.getScore() - Integer.parseInt(bet);
			player.setScore(newScore);
			view.lostMessage();
			view.rolledNumber(this.winner, this.targetResult, this.targetSection);
			view.showPlayerBalance();
		}
		
	}
	
	public void callAndValidateForAutomated() {
		askGameInitiatingQuestions();
		String automatedBetNum = controller.validateAutomatedBetNumber();
		this.parsedBetNum = Integer.parseInt(automatedBetNum);
		
	}
	
	public boolean callLoopForAutomatedBet(double targetResult) {
		this.winner = controller.generateWinningNumber();
		return controller.playerWonOrLost(winner, targetResult);
	}
	
	public void playWithAutomatedMode(String betMultiply, String bet, double targetResult) {
		view.showAutomatedModeStartMessage();
		callAndValidateForAutomated();
		while (player.getScore() > 0 && parsedBetNum > 0) {
			parsedBetNum -= 1;
			boolean wonOrLost = callLoopForAutomatedBet(targetResult);
			doUserWin(wonOrLost, betMultiply, bet);
			
		}
		
	}
	

}
