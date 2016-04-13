package mobi.duckseason.cowgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class GameScreen implements Screen {
	private static int WIDTH = 960;
	private static int HEIGHT = 540;
	
	private Stage stage;
	
	public GameScreen() {
		ScalingViewport v = new ScalingViewport(Scaling.stretch, WIDTH, HEIGHT);
		stage = new Stage(v);
		Gdx.input.setInputProcessor(stage);
		

		//uncomment following line to see the game over image when starting your game
		//showGameOver();
	}
	
	private void showGameOver() {
		Image gameOver = new Image(new Texture("gameOver.png"));
		float x = (WIDTH - gameOver.getWidth()) / 2;
		float y = (HEIGHT) / 2;
		
		gameOver.setPosition(x, y);
		stage.addActor(gameOver);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.7f, 0.7f, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//make the stage do all the processing needed
		stage.act(delta);
		
		//draw the stage
		stage.draw();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
