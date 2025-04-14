package L16.cyborg;

public enum Reaktion {
	RECHTS,
	LINKS,
	BREMSEN,
	UNENTSCHIEDEN;

	@Override
	public String toString() {
		return switch(this) {
			case RECHTS -> "Rechts";
			case LINKS -> "Links";
			case BREMSEN -> "Bremsen";
			case UNENTSCHIEDEN -> "Unentschieden";
		};
	}
}
