package L16.cyborg;

public interface Autofahren {
	// :c cant require implementors to have own static func;
	public Reaktion entscheide(Gefahr g);

	public static Reaktion default_reaction(Gefahr g) {
		return switch (g) {
			case Gefahr.LINKS -> Reaktion.RECHTS;
			case Gefahr.RECHTS -> Reaktion.LINKS;
			case Gefahr.VORNE -> Reaktion.BREMSEN;
		};
	}

	public static String formatted_out(Reaktion r, Gefahr g, String class_name) {
		return class_name + " hat auf eine Gefahr von " + g + " mit " + r + " reagiert";
	}
}
