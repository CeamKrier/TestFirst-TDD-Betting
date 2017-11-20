package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameControllerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void shouldReturnPlayerTargetRangeLowerSection() {
		GameEngine ge = mock(GameEngine.class);
		ConsoleView cv = mock(ConsoleView.class);
		Player pl = mock(Player.class);
		GameController sut = new GameController(ge ,cv, pl);
		
		double actual = sut.playerTargetRange("5", "2");
		assertEquals(true, (actual < 50.1));
	}
	
	@Test
	void shouldReturnPlayerTargetRangeUpperSection() {
		GameEngine ge = mock(GameEngine.class);
		ConsoleView cv = mock(ConsoleView.class);
		Player pl = mock(Player.class);
		GameController sut = new GameController(ge ,cv, pl);
		
		double actual = sut.playerTargetRange("5", "1");
		assertEquals(true, (actual < 50.1));
	}


}
