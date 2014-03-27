package pl.lucek.modernstix;

import pl.lucek.modernstix.components.ColorAnimation;
import pl.lucek.modernstix.components.ParallaxStar;
import pl.lucek.modernstix.components.Position;
import pl.lucek.modernstix.components.Sprite;
import pl.lucek.modernstix.components.Velocity;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.math.MathUtils;

public class EntityFactory {

	public static Entity createStar(World world) {
		Entity e = world.createEntity();
		
		Position position = new Position();
		position.x = MathUtils.random(-ModernStix.FRAME_WIDTH/2, ModernStix.FRAME_WIDTH/2);
		position.y = MathUtils.random(-ModernStix.FRAME_HEIGHT/2, ModernStix.FRAME_HEIGHT/2);
		e.addComponent(position);
		
		Sprite sprite = new Sprite();
		sprite.name = "particle";
		sprite.scaleX = sprite.scaleY = MathUtils.random(0.5f, 1f);
		sprite.a = MathUtils.random(0.1f, 0.5f);
		sprite.layer = Sprite.Layer.BACKGROUND;
		e.addComponent(sprite);
		
		Velocity velocity = new Velocity();
		velocity.vectorY = MathUtils.random(-10f, -60f);
		e.addComponent(velocity);
		
		e.addComponent(new ParallaxStar());
		
		ColorAnimation colorAnimation = new ColorAnimation();
		colorAnimation.alphaAnimate = true;
		colorAnimation.repeat = true;
		colorAnimation.alphaSpeed = MathUtils.random(0.2f, 0.7f);
		colorAnimation.alphaMin = 0.1f;
		colorAnimation.alphaMax = 0.5f;
		e.addComponent(colorAnimation);
		
		return e;
	}

}
