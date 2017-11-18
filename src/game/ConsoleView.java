package game;

import java.io.PrintStream;

public class ConsoleView {
	
	final String WELCOME = "< Welcome to casino >\n\n"
			+ "Here is your chance to make some serious money!\n"
			+ "All you need to do is start betting with our generous gift of 10 coins.\n"
			+ "Don't forget to follow the given instructions to understand how the game works!\n";
	public void showWelcomeMessage() {
		PrintStream out = System.out;
		out.print(WELCOME);
	}
	
	public String askUserBetAmount() {
		return "";
	}

}
