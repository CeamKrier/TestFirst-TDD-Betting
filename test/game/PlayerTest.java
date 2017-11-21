package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	private Player sut;

	@BeforeEach
	void setUp() throws Exception {
		sut = new Player();
	}

	@Test
	void shouldGetCurrentPlayerScore() {
		int actual = sut.getScore();
		assertEquals(sut.playerScore, actual);
	}
	
	@Test
	void shouldSetNewPlayerScore() {
		sut.setScore(20);
		assertEquals(20, sut.playerScore);
	}

}
