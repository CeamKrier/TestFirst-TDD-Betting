package game;

import java.util.Random;

public class GameController {

	public final String REGEX_ONLY_NUMBERS = "^[1-9][0-9]*$";
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
		String autoBets = view.askUserHowManyTimesToAutomateBetting();
		while(!autoBets.matches(REGEX_ONLY_NUMBERS)) {
			autoBets = view.askUserHowManyTimesToAutomateBetting();
		}
		return autoBets;
		
	}

	public String validateBetInput() {
		String bet = view.askUserBetAmount();
		while(!bet.matches(REGEX_ONLY_NUMBERS) || (Integer.parseInt(bet)) > player.getScore()) {
			bet = view.askUserBetAmount();
		}
		return bet;
		
	}

	public String validateBetTarget() {
		String target = view.askUserTheBetTarget();
		while(!target.matches(REGEX_ONLY_NUMBERS) || !(Integer.parseInt(target)>1 && Integer.parseInt(target)<100)) {
			target = view.askUserTheBetTarget();
		}
		return target;
		
	}

	public String validateBetTargetSection() {
		String targetSection = view.askUserToTargetUpperOrLower();
		while(!(targetSection.equals("1") || targetSection.equals("2"))) {
			targetSection = view.askUserToTargetUpperOrLower();
		}
		return targetSection;
		
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

	public String validateDoesUserWantToPlayAgain() {
		// TODO Auto-generated method stub
		return "";
	}
		

}
