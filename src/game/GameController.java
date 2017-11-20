package game;

import java.util.Random;

public class GameController {

	private final String REGEX_ONLY_NUMBERS = "^[1-9][0-9]*$";
	private GameEngine engine;
	private ConsoleView view;
	private Player player;
	private Random random;

	public GameController(GameEngine ge, ConsoleView cv, Player pl) {
		this.engine = ge;
		this.view = cv;
		this.player = pl;
		this.random = new Random();
	}

	public void defineGameMode(int choice) {
		if (choice == 1) {
			engine.playWithClassicMode(engine.betMultiply, engine.bet);
		} else if (choice == 2) {
			engine.playWithAutomatedMode(engine.betMultiply, engine.bet, engine.targetResult);
		}
	}
	
	public String validateAutomatedBetNumber() {
		// TODO Auto-generated method stub
		return "";
		
	}

	public String validateBetInput() {
		// TODO Auto-generated method stub
		return "";
		
	}

	public String validateBetTarget() {
		// TODO Auto-generated method stub
		return "";
		
	}

	public String validateBetTargetSection() {
		// TODO Auto-generated method stub
		return "";
		
	}

	public double playerTargetRange(String multiply, String upperOrLower) {
		int parsedData = Integer.parseInt(multiply);
		final double divisor = 100.0;
		double targetRange = divisor / parsedData;
		if (upperOrLower.equals("1")) {
			return (divisor - targetRange);
		} else {
			return targetRange;
		}
		
	}

	public double generateWinningNumber() {
		return random.nextDouble()*100;
		
	}

	public boolean playerWonOrLost(double winningNumber, double targetRange) {
		if (targetRange > 50.1) {
			return winningNumber > targetRange;
		} else {
			return winningNumber < targetRange;
		}
	}
		

}
