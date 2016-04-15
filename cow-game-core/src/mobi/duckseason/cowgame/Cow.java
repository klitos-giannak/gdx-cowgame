package mobi.duckseason.cowgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Cow extends Image {

	public Cow() {
		super(new Texture("cow.png"));
		
	}
	
	public Rectangle getBounds() {
		//return the Actor rectangle smaller than actual for better visual overlapping
		//of cow and bomb
	    return new Rectangle((int)getX(), (int)getY(), (int)getWidth()-10, (int)getHeight()-30);
	}
}
