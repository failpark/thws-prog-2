package L16.schach;

public abstract class AbstractFigur implements Figur {
	int x;
	int y;

	public static boolean is_even(int x) {
		return (x % 2) == 0;
	}

	public boolean is_black() {
		return is_black(this.x, this.y);
	}

	public static boolean is_black(int x, int y) {
		return is_even(x) == is_even(y);
	}

	public static boolean is_valid(int x) {
		return (x >= 1 && x <= 8);
	};

	public AbstractFigur(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public final void setX(int x) {
		if (is_valid(x)) this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (is_valid(y)) this.y = y;
	}
}
