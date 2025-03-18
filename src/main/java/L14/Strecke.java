package L14;

public class Strecke {
	public int A;
	public int B;

	private static void validate_pos(int a) {
		if (0 <= a) {
			return;
		}
		throw new RuntimeException("Point has to be positive");
	}

	public Strecke(int a, int b) {
		validate_pos(a);
		validate_pos(b);
		int max = a;
		int min = b;
		if (max < b) {
			max = b;
			min = a;
		}
		this.A = min;
		this.B = max;
	}

	public static boolean intersects(Strecke a, Strecke b) {
		return _intersects(a, b) || _intersects(b, a);
	}

	private static boolean _intersects(Strecke left, Strecke right) {
		return right.A < left.B && left.A < right.B;
	}

	@Override
	public String toString() {
		String out = "";
		out += this.A;
		if (this.A == this.B) {
			return out;
		}
		for (int i = (this.A + 1); i <= this.B; i++) {
			out += "-";
		}
		out += this.B;
		return out;
	}
}
