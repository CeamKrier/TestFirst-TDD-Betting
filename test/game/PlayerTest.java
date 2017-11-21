package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void shouldGetCurrentPlayerScore() {
		Player sut = new Player();
		int actual = sut.getScore();
		assertEquals(sut.playerScore, actual);
	}
	
	

}
