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
		sut.run();
		verify(cv).showWelcomeMessage();
		verify(cv).askUserWhichPlayModeIsWanted();
		when(cv.askUserWhichPlayModeIsWanted()).thenReturn("1");
		verify(gc).defineGameMode(1);
	}

}
