package L21;

public class NutritionalContent {
	private int portion_size;
	private int portion_count;
	private int protein;
	private int fat;
	private int calories;
	private int sodium;

	public NutritionalContent(int portion_size, int portion_count) {
		this.portion_size = portion_size;
		this.portion_count = portion_count;
	}

	public NutritionalContent protein(int protein) {
		this.protein = protein;
		return this;
	}

	public NutritionalContent fat(int fat) {
		this.fat = fat;
		return this;
	}

	public NutritionalContent calories(int calories) {
		this.calories = calories;
		return this;
	}

	public NutritionalContent sodium(int sodium) {
		this.sodium = sodium;
		return this;
	}
}
