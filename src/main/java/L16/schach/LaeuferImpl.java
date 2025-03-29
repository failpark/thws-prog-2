package L16.schach;

public class LaeuferImpl extends AbstractFigur implements Laeufer {
	public LaeuferImpl(int x, int y) {
		super(x, y);
	}

	public static void main(String[] args) {
		LaeuferImpl l = new LaeuferImpl(4, 5);
		Brett brett = l.gibErlaubteFelder();
		System.out.println(brett);
	}

	private static boolean is_valid_move(int src_x, int src_y, int dest_x, int dest_y) {
		return Math.abs(src_x - dest_x) == Math.abs(src_y - dest_y);
	}

	public Brett gibErlaubteFelder() {
		Brett brett = new Brett();
		int src_x = this.getX();
		int src_y = this.getY();
		for (int dest_x = 1; dest_x <= Brett.DIM; dest_x++) {
			for (int dest_y = 1; dest_y <= Brett.DIM; dest_y++) {
				if (is_valid_move(src_x, src_y, dest_x, dest_y)) {
					brett.markiereFeld(dest_x, dest_y);
				}
			}
		}
		return brett;
	}

	public Brett general_allowed_moves() {
		Brett brett = new Brett();
		boolean black = is_black();
//		we work with offsets here for whatever reason
		for (int x = 1; x <= brett.brett.length; x++) {
			for (int y = 1; y <= brett.brett[x - 1].length; y++) {
				if (Brett.is_black(x, y) == black) {
					brett.markiereFeld(x, y);
				}
			}
		}
		return brett;
	}

}
