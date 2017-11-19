package game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameEngineTest {

	private ConsoleView cv;
	private GameController gc;
	private GameEngine sut;
	private Player pl;

	@BeforeEach
	void setUp() throws Exception {
		cv = mock(ConsoleView.class);
		pl = mock(Player.class);
		gc = mock(GameController.class);
		sut = new GameEngine(cv, gc, pl);
	}

	@Test
	void shouldStartTheGame() {
		
		when(cv.askUserWhichPlayModeIsWanted()).thenReturn("1");
		sut.run();
		verify(cv).showWelcomeMessage();
		verify(cv).askUserWhichPlayModeIsWanted();
		verify(gc).defineGameMode(1);
	}
	
	void verifyInitialQuestionsToPlayer() {
		verify(gc).validateBetInput();
		verify(gc).validateBetTarget();
		verify(gc).validateBetTargetSection();
		verify(gc).playerTargetRange("5", "1");
	}
	
	void returnResultsForValidatedQuestions() {
		when(gc.validateBetTarget()).thenReturn("5");
		when(gc.validateBetTargetSection()).thenReturn("1");
	}
	
	@Test
	void shoulAskGameInitiatingQuestions() {
		returnResultsForValidatedQuestions();
		sut.askGameInitiatingQuestions();
		verifyInitialQuestionsToPlayer();
	}
	
	void verifyForClassicModeValidationAndPlayingWithClassicMode() {
		verifyInitialQuestionsToPlayer();
		verify(gc).generateWinningNumber();
		verify(gc).playerWonOrLost(93.33, 80.0);
	}
	
	void returnForClassicModeValidationAndPlayingWithClassicMode() {
		returnResultsForValidatedQuestions();
		when(gc.generateWinningNumber()).thenReturn(93.33);
		when(gc.playerTargetRange("5", "1")).thenReturn(80.0);
	}
	
	@Test
	void shoulCallAndValidateForClassic() {
		returnForClassicModeValidationAndPlayingWithClassicMode();
		sut.callAndValidateForClassic();
		verifyForClassicModeValidationAndPlayingWithClassicMode();
	}
	
	@Test
	void shoulPlayWithClassicMode() {
		when(pl.getScore()).thenReturn(10);
		returnForClassicModeValidationAndPlayingWithClassicMode();
		sut.playWithClassicMode("4", "4");
		verify(cv).showClassicModeStartMessage();
		verifyForClassicModeValidationAndPlayingWithClassicMode();
	}
	
	
	@Test
	void shoulShowDoUserWin() {
		when(pl.getScore()).thenReturn(10);
		sut.doUserWin(false, "5", "5");
		verify(cv).lostMessage();
		sut.doUserWin(true, "5", "5");
		verify(cv).wonMessage();
		
	}

	@Test
	void shoulCallAndValidateForAutomated() {
		when(gc.validateAutomatedBetNumber()).thenReturn("10");
		sut.callAndValidateForAutomated();
		verify(gc).validateAutomatedBetNumber();
		
	}

}
