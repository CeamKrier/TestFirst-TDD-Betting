package game;

public class GameController {

	private final String REGEX_ONLY_NUMBERS = "^[1-9][0-9]*$";
	private GameEngine engine;
	private ConsoleView view;
	private Player player;

	public GameController(GameEngine ge, ConsoleView cv, Player pl) {
		this.engine = ge;
		this.view = cv;
		this.player = pl;
	}

	public void defineGameMode(int choice) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return 0.0;
		
	}

	public boolean playerWonOrLost(double winningNumber, double targetRange) {
		return false;
	}
		

	public String validateAutomatedBetNumber() {
		// TODO Auto-generated method stub
		return "";
		
	}


}
