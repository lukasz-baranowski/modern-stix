package pl.lucek.modernstix;

import pl.lucek.modernstix.systems.ColorAnimationSystem;
import pl.lucek.modernstix.systems.MovementSystem;
import pl.lucek.modernstix.systems.ParallaxStarRepeatingSystem;
import pl.lucek.modernstix.systems.SpriteRenderSystem;

import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {
	private World world;
	private OrthographicCamera camera;

    private SpriteRenderSystem spriteRenderSystem;

	public GameScreen() {
		this.camera = new OrthographicCamera(ModernStix.FRAME_WIDTH, ModernStix.FRAME_HEIGHT);

		world = new World();

		world.setSystem(new ColorAnimationSystem());
		world.setSystem(new MovementSystem());
		world.setSystem(new ParallaxStarRepeatingSystem());

		spriteRenderSystem = world.setSystem(new SpriteRenderSystem(camera), true);

		world.initialize();

		for(int i = 0; 500 > i; i++) {
			EntityFactory.createStar(world).addToWorld();
		}
	}

	@Override
	public void render(float arg0) {
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();

		world.setDelta(arg0);
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			for (int i = 0; 10 > i; i++) {
				world.process();
			}
		}
		world.process();

		spriteRenderSystem.process();
	}

	@Override
	public void dispose() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resize(int arg0, int arg1) {
	}

	@Override
	public void resume() {
	}

	@Override
	public void show() {
	}

}
