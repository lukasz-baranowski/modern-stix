package pl.lucek.modernstix.systems;

import pl.lucek.modernstix.ModernStix;
import pl.lucek.modernstix.components.ParallaxStar;
import pl.lucek.modernstix.components.Position;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.IntervalEntityProcessingSystem;

public class ParallaxStarRepeatingSystem extends IntervalEntityProcessingSystem {
	@Mapper
	ComponentMapper<Position> pm;

	@SuppressWarnings("unchecked")
	public ParallaxStarRepeatingSystem() {
		super(Aspect.getAspectForAll(ParallaxStar.class, Position.class), 1);
	}

	@Override
	protected void process(Entity e) {
		Position position = pm.get(e);

		if (position.y < -ModernStix.FRAME_HEIGHT / 2) {
			position.y = ModernStix.FRAME_HEIGHT / 2;
		}
	}

}
