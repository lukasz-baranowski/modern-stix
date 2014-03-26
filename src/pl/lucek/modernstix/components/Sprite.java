package pl.lucek.modernstix.components;

import com.artemis.Component;

public class Sprite extends Component {
	public enum Layer {
		DEFAULT       (1),
		BACKGROUND    (2),
		ACTORS_1      (3),
		ACTORS_2      (4),
		ACTORS_3      (5),
		PARTICLES     (6);

		private int id;
		private Layer(int id) {
		    this.id = id;
		}
		public int getLayerId() {
			return id;
		}
	}

	public String name;
	public float scaleX = 1;
	public float scaleY = 1;
	public float rotation;
	public float r = 1;
	public float g = 1;
	public float b = 1;
	public float a = 1;
	public Layer layer = Layer.DEFAULT;
}
