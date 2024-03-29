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
	
	@Test
	void shouldReturnDefinedGameModeForClassic() {
		sut.defineGameMode(1);
		verify(ge).playWithClassicMode(null, null);
	}
	
	@Test
	void shouldReturnDefinedGameModeForAutomated() {
		sut.defineGameMode(2);
		verify(ge).playWithAutomatedMode(null, null, 0);
	}
	
	@Test
	void shouldReturnValidatedBetStringThatIsANumber() {
		when(cv.askUserBetAmount()).thenReturn("10");
		when(pl.getScore()).thenReturn(10);
		String actual = sut.validateBetInput();
		assertEquals(true, actual.matches(sut.REGEX_ONLY_NUMBERS));
	}

	@Test
	void shouldReturnValidatedBetTargetStringThatIsANumber() {
		when(cv.askUserTheBetTarget()).thenReturn("10");
		String actual = sut.validateBetTarget();
		assertEquals(true, actual.matches(sut.REGEX_ONLY_NUMBERS));
	}
	
	@Test
	void shouldReturnValidatedBetTargetStringThatIsANumberAndGreaterThanOne() {
		when(cv.askUserTheBetTarget()).thenReturn("10");
		String actual = sut.validateBetTarget();
		assertEquals(true, Integer.parseInt(actual) > 1);
	}
	
	@Test
	void shouldReturnValidatedBetTargetStringThatIsANumberAndSmallerThanHundred() {
		when(cv.askUserTheBetTarget()).thenReturn("10");
		String actual = sut.validateBetTarget();
		assertEquals(true, Integer.parseInt(actual) < 100);
	}
	
	@Test
	void shouldReturnValidatedBetTargetSectionStringThatIsANumberAndUpperSection() {
		when(cv.askUserToTargetUpperOrLower()).thenReturn("1");
		String actual = sut.validateBetTargetSection();
		assertEquals(true, actual.equals("1"));
	}
	
	@Test
	void shouldReturnValidatedBetTargetSectionStringThatIsANumberAndLowerSection() {
		when(cv.askUserToTargetUpperOrLower()).thenReturn("2");
		String actual = sut.validateBetTargetSection();
		assertEquals(true, actual.equals("2"));
	}
	
	@Test
	void shouldReturnAutomatedBetStringThatIsNumber() {
		when(cv.askUserHowManyTimesToAutomateBetting()).thenReturn("3");
		String actual = sut.validateAutomatedBetNumber();
		assertEquals(true, actual.matches(sut.REGEX_ONLY_NUMBERS));
	}
	
	@Test
	void shouldReturnUserRespondAboutReplayGame() {
		when(cv.askDoesUserWantsToPlayAgain()).thenReturn("yes");
		String actual = sut.validateDoesUserWantToPlayAgain();
		assertEquals(true, actual.equals("yes"));
	}
	
	@Test
	void shouldShowRefuelBalanceMessageIfCurrentBalanceIsNotSufficient() {
		when(pl.getScore()).thenReturn(0);
		when(cv.askDoesUserWantsToPlayAgain()).thenReturn("yes");
		sut.validateDoesUserWantToPlayAgain();
		verify(cv).showRefuelBalanceMessage();
	}
	

}
