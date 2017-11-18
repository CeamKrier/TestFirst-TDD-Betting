package game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleViewTest {

	private ByteArrayOutputStream outContent;
	private ConsoleView sut;
	@BeforeEach
	void setUp() throws Exception {
		sut = new ConsoleView(new GameEngine());
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
	
	@Test
	void shouldAskPlayModeToUserAndBeSureThereIsARespond() {
	    String respond = sut.askUserWhichPlayModeIsWanted();
	    String expectedOutput  = sut.PLAY_MODE;
	    assertEquals(expectedOutput, outContent.toString());
	    assertNotNull(respond);
	}
	
	@Test
	void shouldAskUserTheBetTargetAndBeSureThereIsARespond() {
	    String respond = sut.askUserTheBetTarget();
	    String expectedOutput  = sut.TARGET;
	    assertEquals(expectedOutput, outContent.toString());
	    assertNotNull(respond);
	}
	
	@Test
	void shouldAskUserToTargetUpperOrLowerAndBeSureThereIsARespond() {
	    String respond = sut.askUserToTargetUpperOrLower();
	    String expectedOutput  = sut.UPPER_LOWER;
	    assertEquals(expectedOutput, outContent.toString());
	    assertNotNull(respond);
	}
	
	@Test
	void shouldShowPlayerBalance() {
		sut.showPlayerBalance();
	    boolean expectedOutput  = true;
	    assertEquals(expectedOutput, outContent.toString().contains("balance"));
	    assertFalse(outContent.toString().contains("null"));
	    
	}
	
	@Test
	void shouldShowPlayerWonMessage() {
		sut.wonMessage();
	    String expectedOutput  = "You won";
	    assertEquals(expectedOutput, outContent.toString());
	}
	

}
