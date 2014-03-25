package pl.lucek.modernstix;

import com.artemis.World;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {
	private Game game;
	private World world;
	private OrthographicCamera camera;

	public GameScreen(Game game) {
		this.game = game;
		this.camera = new OrthographicCamera(ModernStix.FRAME_WIDTH, ModernStix.FRAME_HEIGHT);

		world = new World();
		world.initialize();
	}

	@Override
	public void render(float arg0) {
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();

		world.setDelta(arg0);
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			for(int i = 0; 10 > i; i++) {
				world.process();
			}
		}
		world.process();
		
//		spriteRenderSystem.process();
//		healthRenderSystem.process();
//		hudRenderSystem.process();
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
