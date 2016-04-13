package mobi.duckseason.cowgame;

import com.badlogic.gdx.Game;

public class CowGame extends Game {
	
	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}
