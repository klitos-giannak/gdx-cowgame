package mobi.duckseason.cowgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bomb extends Image {

	public Bomb() {
		super(new Texture("bomb.png"));
	}
	
	public Rectangle getBounds() {
	    return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
	}
}
