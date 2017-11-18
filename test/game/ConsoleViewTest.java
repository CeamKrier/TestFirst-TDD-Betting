package game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleViewTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void shouldShowWelcomeMessage() {
		ConsoleView sut = new ConsoleView();
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    sut.showWelcomeMessage();
	    String expectedOutput  = "Welcome";
	    assertEquals(expectedOutput, outContent.toString());
	}

}
