package game;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleView {
	
	private PrintStream out;
	public ConsoleView() {
		this.out = System.out;
	}
	
	final String WELCOME = "< Welcome to casino >\n\n"
			+ "Here is your chance to make some serious money!\n"
			+ "All you need to do is start betting with our generous gift of 10 coins.\n"
			+ "Don't forget to follow the given instructions to understand how the game works!\n"
			+ "Good luck and have fun!\n";
	final String BET = "\nPlease enter the amount you want to bet (number): ";
	public void showWelcomeMessage() {
		out.print(WELCOME);
	}
	
	public String askUserBetAmount() {
		Scanner sc = new Scanner(System.in);
		out.print(BET);
		return sc.nextLine();
	}

}
