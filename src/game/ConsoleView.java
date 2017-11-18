package game;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleView {
	
	final String WELCOME = "< Welcome to casino >\n\n"
			+ "Here is your chance to make some serious money!\n"
			+ "All you need to do is start betting with our generous gift of 10 coins.\n"
			+ "Don't forget to follow the given instructions to understand how the game works!\n"
			+ "Good luck and have fun!\n";
	final String BET = "\nPlease enter the amount you want to bet (number): ";
	public void showWelcomeMessage() {
		PrintStream out = System.out;
		out.print(WELCOME);
	}
	
	public String askUserBetAmount() {
		Scanner sc = new Scanner(System.in);
		PrintStream out = System.out;
		out.print(BET);
		return sc.nextLine();
	}

}
