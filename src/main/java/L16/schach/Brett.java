package L16.schach;

public class Brett {
	public static final int DIM = 8;
	public static final char[] PIPES = new char[]{'│', '│', '─', '─', '┌', '┐', '└', '┘'};
	boolean[][] brett = new boolean[DIM][DIM];
	private static String ROW_DESC = "A B C D E F G H";

	public Brett() {
		if (DIM != 8) {
			ROW_DESC = gen_row_desc();
		}
	}

	Brett(boolean[][] init) {
		if (init.length != DIM || init[0].length != DIM) {
			throw new RuntimeException("Mismatched Dimensions");
		}
		this.brett = init;
	}

	public void clear() {
		this.brett = new boolean[DIM][DIM];
	}

	public Brett kombiniere(Brett other) {
		return this.merge(other);
	}

	public Brett merge(Brett other) {
		// we don't need to check if the dimensions match because we use DIM as class constant
		// we could just modify this.brett or other.brett but I think Java doesn't pass by copy
		// create a new board just to be safe
		Brett tmp = new Brett();
		tmp.brett = this.brett;
		for (int x = 0; x < DIM; x++) {
			for (int y = 0; y < DIM; y++) {
				tmp.brett[x][y] = merge_field(x, y, this.brett, other.brett);
			}
		}
		return tmp;
	}

	private static boolean merge_field(int x, int y, boolean[][] left, boolean[][] right) {
		return left[x][y] || right[x][y];
	}

	public void markiereFeld(int x, int y) {
		brett[x - 1][y - 1] = true;
	}

	public boolean gibFeld(int x, int y) {
		return brett[x - 1][y - 1];
	}

	public static boolean is_black(int x, int y) {
		return AbstractFigur.is_black(x, y);
	}

	@Override
	public String toString() {
		String out = get_top_desc() + "\n";
		// print the board from own POW
		// left to right bottom to top
		for (int x = DIM - 1; 0 <= x; x--) {
			out += (x + 1) + " ";
			for (int y = 0; y < brett[x].length; y++) {
				if (brett[x][y]) {
					out += "x ";
				} else {
					out += "o ";
				}
			}
			out += (x + 1) + "\n";
		}
		out += get_bottom_desc();
		return out;
	}

	private String get_top_desc() {
		return get_formatted_row_desc(4);
	}

	private String get_bottom_desc() {
		return get_formatted_row_desc(6);
	}

	private String get_formatted_row_desc(int start) {
		return PIPES[start] + " " + ROW_DESC + " " + PIPES[start + 1];
	}

	public String gen_row_desc() {
		String out = "";
		char start = 'A';
		for(int i = 0; i < DIM; i++) {
			out += (start++) + " ";
		}
		return out;
	}

	public void debug() {
		String out = "{\n";
		for(int x = 0; x < DIM; x++) {
			out += "{";
			for (int y = 0; y < DIM; y++) {
				out += this.brett[x][y] ? "true" :  "false";
				out += y == (DIM - 1) ? "" : ", ";
			}
			out += x == (DIM - 1) ? "}\n" : "},\n";
		}
		out += "}";
		System.out.println(out);
	}
}
