package game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameEngineTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void shouldStartTheGame() {
		ConsoleView cv = mock(ConsoleView.class);
		GameController gc = mock(GameController.class);
		GameEngine sut = new GameEngine(cv, gc);
		when(cv.askUserWhichPlayModeIsWanted()).thenReturn("1");
		sut.run();
		verify(cv).showWelcomeMessage();
		verify(cv).askUserWhichPlayModeIsWanted();
		verify(gc).defineGameMode(1);
	}
	
	@Test
	void shoulAskGameInitiatingQuestions() {
		ConsoleView cv = mock(ConsoleView.class);
		GameController gc = mock(GameController.class);
		GameEngine sut = new GameEngine(cv, gc);
		when(gc.validateBetTarget()).thenReturn("5");
		when(gc.validateBetTargetSection()).thenReturn("1");
		sut.askGameInitiatingQuestions();
		verify(gc).validateBetInput();
		verify(gc).validateBetTarget();
		verify(gc).validateBetTargetSection();
		verify(gc).playerTargetRange("5", "1");
	}

}
