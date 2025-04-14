package L16.cyborg;

public enum Gefahr {
	LINKS,
	RECHTS,
	VORNE;

	@Override
	public String toString() {
		return switch (this) {
			case LINKS -> "Links";
			case RECHTS -> "Rechts";
			case VORNE -> "Vorne";
		};
	}
}
