package game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameEngineTest {

	private ConsoleView cv;
	private GameController gc;
	private GameEngine sut;

	@BeforeEach
	void setUp() throws Exception {
		cv = mock(ConsoleView.class);
		gc = mock(GameController.class);
		sut = new GameEngine(cv, gc);
	}

	@Test
	void shouldStartTheGame() {
		
		when(cv.askUserWhichPlayModeIsWanted()).thenReturn("1");
		sut.run();
		verify(cv).showWelcomeMessage();
		verify(cv).askUserWhichPlayModeIsWanted();
		verify(gc).defineGameMode(1);
	}
	
	@Test
	void shoulAskGameInitiatingQuestions() {
		when(gc.validateBetTarget()).thenReturn("5");
		when(gc.validateBetTargetSection()).thenReturn("1");
		sut.askGameInitiatingQuestions();
		verify(gc).validateBetInput();
		verify(gc).validateBetTarget();
		verify(gc).validateBetTargetSection();
		verify(gc).playerTargetRange("5", "1");
	}
	
	@Test
	void shoulCallAndValidateForClassic() {
		when(gc.validateBetTarget()).thenReturn("5");
		when(gc.validateBetTargetSection()).thenReturn("1");
		when(gc.generateWinningNumber()).thenReturn(93.33);
		when(gc.playerTargetRange("5", "1")).thenReturn(80.0);
		sut.askGameInitiatingQuestions();
		verify(gc).validateBetInput();
		verify(gc).validateBetTarget();
		verify(gc).validateBetTargetSection();
		verify(gc).playerTargetRange("5", "1");
		verify(gc).generateWinningNumber();
		verify(gc).playerWonOrLost(93.33, 80.0);
	}

}
