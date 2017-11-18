package game;

public class GameEngine {

	public Player player;
	
	public GameEngine() {
		player = new Player();
	}
	
	public Player getCurrentPlayer() {
		return player;
	}

}
