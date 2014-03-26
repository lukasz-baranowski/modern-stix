package pl.lucek.modernstix;

import pl.lucek.modernstix.utils.ImagePacker;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class ModernStix extends Game {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;

	@Override
	public void create() {
		setScreen(new GameScreen());
    }

	public static void main(String[] args) {
	    ImagePacker.run();

		LwjglApplicationConfiguration lwjglApplicationConfiguration = new LwjglApplicationConfiguration();
		lwjglApplicationConfiguration.fullscreen = false;
		lwjglApplicationConfiguration.width = FRAME_WIDTH;
		lwjglApplicationConfiguration.height = FRAME_HEIGHT;
//		lwjglApplicationConfiguration.useCPUSynch = false;
		lwjglApplicationConfiguration.vSyncEnabled = false;
		lwjglApplicationConfiguration.title = "Modern Stix";
		new LwjglApplication(new ModernStix(), lwjglApplicationConfiguration);
	}

}
