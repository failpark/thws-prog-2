package L15.drink_stock;

public class Drink {
	String name;
	String origin;
	String kind;
	float alcoholic_content;

	public Drink(String name, String origin, String kind, float alcoholic_content) {
		this.name = name;
		this.origin = origin;
		this.kind = kind;
		this.alcoholic_content = alcoholic_content;
	}

	public boolean is_non_alcoholic() {
		return this.alcoholic_content < 0.5f;
	}

	String basic_out() {
		return "Herkunft: " + this.origin +
				"\nSorte: " + this.kind +
				"\nAlkoholgehalt: " + this.alcoholic_content;
	}

	@Override
	public String toString() {
		return basic_out() +
				"\nalkoholfrei: " + (is_non_alcoholic() ? "ja" : "nein");
	}

	public static void main(String[] args) {
		Drink[] drinks = {
				new Beer("Bier", "Eichhofen", "Helles", 5.0f),
				new WhiteWine("Weißwein", "Randesacker", "Silvaner", 12.5f, 2022),
				new RedWine("Rosé", "Lauda-Königshofen", "Rose", 12.5f, 2021),
		};

		for (Drink drink : drinks) {
			System.out.println(drink);
			System.out.println();
		}
	}
}
