package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameControllerTest {

	private GameEngine ge;
	private ConsoleView cv;
	private Player pl;
	private GameController sut;

	@BeforeEach
	void setUp() throws Exception {
		ge = mock(GameEngine.class);
		cv = mock(ConsoleView.class);
		pl = mock(Player.class);
		sut = new GameController(ge ,cv, pl);
	}

	@Test
	void shouldReturnPlayerTargetRangeLowerSection() {
		double actual = sut.playerTargetRange("5", "2");
		assertEquals(true, (actual < 50.1));
	}
	
	@Test
	void shouldReturnPlayerTargetRangeUpperSection() {
		double actual = sut.playerTargetRange("5", "1");
		assertEquals(true, (actual > 50.1));
	}
	
	@Test
	void shouldReturnPlayerWonTheBetInLowerSection() {
		boolean actual = sut.playerWonOrLost(12.34, 15.0);
		assertEquals(true, actual);
	}
	
	@Test
	void shouldReturnPlayerLostTheBetInLowerSection() {
		boolean actual = sut.playerWonOrLost(12.34, 12.0);
		assertEquals(false, actual);
	}
	
	@Test
	void shouldReturnPlayerWonTheBetInUpperSection() {
		boolean actual = sut.playerWonOrLost(66.66, 60.5);
		assertEquals(true, actual);
	}
	
	@Test
	void shouldReturnPlayerLostTheBetInUpperSection() {
		boolean actual = sut.playerWonOrLost(66.66, 68.5);
		assertEquals(false, actual);
	}
	
	@Test
	void shouldReturnGeneratedWinningNumberThatIsBetweenZeroAndHundred() {
		double actual = sut.generateWinningNumber();
		assertEquals(true, (actual < 100));
		assertEquals(true, (actual > 0));
	}
	

}
