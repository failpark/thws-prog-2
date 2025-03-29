package L16.schach;

public class TurmImpl extends AbstractFigur implements Turm {
	public TurmImpl(int x, int y) {
		super(x, y);
	}

	public static void main(String[] args) {
		TurmImpl turm = new TurmImpl(1, 1);
		Brett brett = turm.gibErlaubteFelder();
		System.out.println(brett);
	}

	public Brett gibErlaubteFelder() {
		Brett brett = new Brett();
		for (int i = 1; i <= 8; i++) {
			brett.markiereFeld(i, y);
			brett.markiereFeld(x, i);
		}
		return brett;
	}
}
