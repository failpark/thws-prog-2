package L21;

public class NutritionalContent {
	private final int portionSize;
	private final int portionCount;
	private final int protein;
	private final int fat;
	private final int calories;
	private final int sodium;

	private NutritionalContent(Builder builder) {
		this.portionSize = builder.portionSize;
		this.portionCount = builder.portionCount;
		this.protein = builder.protein;
		this.fat = builder.fat;
		this.calories = builder.calories;
		this.sodium = builder.sodium;
	}

	// Getters
	public int getPortionSize() { return portionSize; }
	public int getPortionCount() { return portionCount; }
	public int getProtein() { return protein; }
	public int getFat() { return fat; }
	public int getCalories() { return calories; }
	public int getSodium() { return sodium; }

	public static class Builder {
		// Required parameters
		private final int portionSize;
		private final int portionCount;

		// Optional parameters - initialized to default values
		private int protein = 0;
		private int fat = 0;
		private int calories = 0;
		private int sodium = 0;

		public Builder(int portionSize, int portionCount) {
			this.portionSize = portionSize;
			this.portionCount = portionCount;
		}

		public Builder protein(int protein) {
			this.protein = protein;
			return this;
		}

		public Builder fat(int fat) {
			this.fat = fat;
			return this;
		}

		public Builder calories(int calories) {
			this.calories = calories;
			return this;
		}

		public Builder sodium(int sodium) {
			this.sodium = sodium;
			return this;
		}

		public NutritionalContent build() {
			return new NutritionalContent(this);
		}
	}
}