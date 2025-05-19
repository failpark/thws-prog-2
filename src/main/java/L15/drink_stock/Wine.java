package L15.drink_stock;

public class Wine extends Drink {
	int year;

	public Wine(String name, String origin, String kind, float alcoholic_content, int year) {
		super(name, origin, kind, alcoholic_content);
		this.year = year;
	}

	String basic_out() {
		return "Herkunft: " + this.origin +
				"\nSorte: " + this.kind +
				"\nAlkoholgehalt: " + this.alcoholic_content +
				"\nJahrgang: " + this.year;
	}
}
