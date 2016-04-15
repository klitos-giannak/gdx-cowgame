package mobi.duckseason.cowgame;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class GameScreen implements Screen {
	private static int WIDTH = 960;
	private static int HEIGHT = 540;
	
	private Stage stage;
	private Cow cow;
	
	public GameScreen() {
		ScalingViewport v = new ScalingViewport(Scaling.stretch, WIDTH, HEIGHT);
		stage = new Stage(v);
		Gdx.input.setInputProcessor(stage);
		
		//test our bomb creation
		//stage.addActor(createBombActor());
		
		//uncomment following line to see the game over image when starting your game
		//showGameOver();
		
		initCow();
	}
	
	private void initCow() {
		cow = new Cow();
		cow.setX( (stage.getWidth()-cow.getWidth())/2 );
		stage.addActor(cow);
	}

	private Bomb createBombActor() {
		Bomb bomb = new Bomb();

		//we need the bomb to appear on a random x point inside our stage's viewport
		//and it's y should be just above our stage's viewport
		int x = new Random().nextInt( (int) (WIDTH-bomb.getWidth()) );
		bomb.setPosition(x, HEIGHT);
		
		//Calculate the distance our bomb should be travel vertically (drop)
		float dropDistance = stage.getHeight()+bomb.getHeight();
		
		//Create an action to add to our bomb actor with the calculated distance
		MoveByAction dropAction = Actions.moveBy(0, -dropDistance, 2);
		
		//Create a combined action.
		//After animating the drop, our actor should be removed from stage
		SequenceAction action = new SequenceAction();
		action.addAction(dropAction);
		action.addAction(Actions.removeActor());
		
		//finally add the combined action to our bomb-actor and return it
		bomb.addAction(action);
		return bomb;
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
