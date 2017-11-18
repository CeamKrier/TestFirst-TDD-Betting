package game;

import java.util.Scanner;

public class ConsoleView {
	
	private Scanner sc;
	public ConsoleView() {
		sc = new Scanner(System.in);
	}
	
	final String WELCOME = "< Welcome to casino >\n\n"
			+ "Here is your chance to make some serious money!\n"
			+ "All you need to do is start betting with our generous gift of 10 coins.\n"
			+ "Don't forget to follow the given instructions to understand how the game works!\n"
			+ "Good luck and have fun!\n";
	final String BET = "\nPlease enter the amount you want to bet (number): ";
	final String PLAY_MODE = "Please select which play mode you want: \n"
			+ "[1] -> Classic mode : One bet each time\n"
			+ "[2] -> Automated mode : Automated bets being done by computer. You can choose how many automated bet will be performed";
	public void showWelcomeMessage() {
		System.out.print(WELCOME);
	}
	
	public String askUserBetAmount() {
		System.out.print(BET);
		return sc.nextLine();
	}
	
	public String askUserWhichPlayModeIsWanted() {
		System.out.print("Select play mode");
		return sc.nextLine();
	}
	
	public String askUserTheBetTarget () {
		return null;
	}

}
