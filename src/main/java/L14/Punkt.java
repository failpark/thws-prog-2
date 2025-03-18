package L14;

public class Punkt {
	int x;
	int y;

	public void verschiebePunkt(int x, int y) {
		if (x < 0 || x > 1920 || y < 0 || y > 1080) {
			throw new RuntimeException("Invalid");
		}
		this.x = x;
		this.y = y;
	}
}
