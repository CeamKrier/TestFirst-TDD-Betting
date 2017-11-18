package game;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleViewTest {

	private ByteArrayOutputStream outContent;
	private ConsoleView sut;

	@BeforeEach
	void setUp() throws Exception {
		sut = new ConsoleView();
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	}
	
	@Test
	void shouldShowWelcomeMessage() {
	    sut.showWelcomeMessage();
	    String expectedOutput  = sut.WELCOME;
	    assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void shouldAskBetAmountToPlayerAndBeSureThereIsARespond() {
	    String respond = sut.askUserBetAmount();
	    String expectedOutput  = sut.BET;
	    assertEquals(expectedOutput, outContent.toString());
	    assertNotNull(respond);
	}

}
