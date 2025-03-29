package L16.schach;

public class Dame extends AbstractFigur implements Laeufer, Turm {
	Laeufer laeufer;
	Turm turm;

	public Dame(int x, int y) {
		super(x, y);
		laeufer = new LaeuferImpl(x, y);
		turm = new TurmImpl(x, y);
	}

	public static void main(String[] args) {
		Dame d = new Dame(4, 5);
		System.out.println(d.gibErlaubteFelder());
		Brett brett = d.gibErlaubteFelder();
		System.out.println(brett);
	}

	@Override
	public Brett gibErlaubteFelder() {
		Brett brettLaeufer = laeufer.gibErlaubteFelder();
		Brett brettTurm = turm.gibErlaubteFelder();
		Brett kombiniertesBrett = brettTurm.kombiniere(brettLaeufer);
		return kombiniertesBrett;
	}
}
