package L16.cyborg;

public class MenschImpl implements Mensch {

	static boolean is_undecided() {
		return ((int)(Math.random() * 4)) == 0;
	}

	public static Reaktion reaction(Gefahr g) {
		if (is_undecided()) return Reaktion.UNENTSCHIEDEN;
		return Autofahren.default_reaction(g);
	}

	public Reaktion entscheide(Gefahr g) {
		return reaction(g);
	}

	@Override
	public String toString() {
		return "Mensch";
	}

	public void essen() {

	}

	public void schlafen() {

	}

	public void arbeiten() {

	}
}
