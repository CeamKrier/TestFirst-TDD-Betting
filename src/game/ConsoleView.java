package game;

import java.util.Scanner;

public class ConsoleView {
	private Scanner sc;
	private GameEngine engine;
	public ConsoleView(GameEngine engine) {
		sc = new Scanner(System.in);
		this.engine = engine;
	}
	
	final String WELCOME = "< Welcome to casino >\n\n"
			+ "Here is your chance to make some serious money!\n"
			+ "All you need to do is start betting with our generous gift of 10 coins.\n"
			+ "Don't forget to follow the given instructions to understand how the game works!\n"
			+ "Good luck and have fun!\n";
	final String PLAY_MODE = "\n\nPlease select which play mode you want: \n"
			+ "[1] -> Classic mode : One bet each time\n"
			+ "[2] -> Automated mode : Automated bets being done by computer. You can choose how many automated bet will be performed\n";
	final String BET = "\n\nPlease enter the amount you want to bet (number): ";
	final String TARGET = "\n\nPlease enter ratio to multiply your bet (a number between 2 to 99): ";
	final String UPPER_LOWER = "\n\nDo you want to bet for upper or lower section?\n"
			+ "[1] -> Upper section (bet for rolls higher then 50.0)\n"
			+ "[2] -> Lower section (bet for rolls lower then 50.0)\n";
	final String WON = "\n\nCongragulations! Yow won.";
	final String LOST = "\n\nUnfortunately you have lost your bet this time..";
	final String CLASSIC = "\n\n< Classic Betting Mode >";
	final String AUTOMATED = "\n\n< Automated Betting Mode >";
	final String AUTO_BET_NUMBER = "\n\nPlease enter how many times you want to automate betting: ";
	final String ROLL = "\n\nYou have rolled: ";
	final String GOODBYE = "\n\nThanks for choosing us! Hoping to see you soon again.";
	final String PLAY_AGAIN = "\n\nDo you want to play again? (yes / no) ";
	final String REFUEL = "\n\nSeems like you lost all your balance but no worries! We will present you 10 coins again if you would like to play!";
	
	
	public void showWelcomeMessage() {
		System.out.print(WELCOME);
	}
	
	public String askUserBetAmount() {
		System.out.print(BET);
		return sc.nextLine();
	}
	
	public String askUserWhichPlayModeIsWanted() {
		System.out.print(PLAY_MODE);
		return sc.nextLine();
	}
	
	public String askUserTheBetTarget () {
		System.out.print(TARGET);
		return sc.nextLine();
	}
	
	public String askUserToTargetUpperOrLower() {
		System.out.print(UPPER_LOWER);
		return sc.nextLine();
	}
	
	public void showPlayerBalance() {
		System.out.print("\n\nYour current balance is " + engine.player.getScore());
	}
	
	public void wonMessage() {
		System.out.print(WON);
	}
	
	public void lostMessage() {
		System.out.print(LOST);
	}
	
	public void showClassicModeStartMessage() {
		System.out.print(CLASSIC);
	}
	
	public void showAutomatedModeStartMessage() {
		System.out.print(AUTOMATED);
		
	}
	
	public String askUserHowManyTimesToAutomateBetting() {
		System.out.print(AUTO_BET_NUMBER);
		return sc.nextLine();
		
	}

	public void rolledNumber(double winner, double targetResult, String targetSection) {
		if (targetSection.equals("1")) {
			System.out.print(ROLL + String.format("%.2f", winner) + " || Target: >" + String.format("%.2f", targetResult) + "");
		} else {
			System.out.print(ROLL + String.format("%.2f", winner) + " || Target: <" + String.format("%.2f", targetResult) + "");
		}
		
	}

	public void showMoneyWithdrawalMessage() {
		System.out.print("\n\nYou have won " + engine.player.getScore() + " coins! You can cash them in the casino whenever you want.");
	}

	public void showGoodbyeMessage() {
		System.out.print(GOODBYE);
		
	}

	public String askDoesUserWantsToPlayAgain() {
		System.out.print(PLAY_AGAIN);
		return sc.nextLine();
	}

	public void showRefuelBalanceMessage() {
		System.out.print(REFUEL);
		
	}

}
