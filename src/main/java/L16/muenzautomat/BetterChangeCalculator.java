package L16.muenzautomat;

public class BetterChangeCalculator implements ChangeCalculator {
	public static class Cent {
		int amount;
		int remainder;
		public Cent(int val, int cent) {
			this.amount = cent / val;
			this.remainder = cent % val;
		}
	}
	public int[] getChange(int euros, int cent) {
		int[] change = new int[8];
		change[6] = get_euro_1(euros);
		change[7] = get_euro_2(euros);
		Cent curr = new Cent(50, cent);
		change[5] = curr.amount;
		Coin[] coins = Coin.values();
		for (int i = 4; 0 <= i; i--) {
			curr = new Cent(coins[i].value, curr.remainder);
			change[i] = curr.amount;
		}

		return change;
	}

	private int get_euro_2(int e) {
		return e / 2;
	}

	private int get_euro_1(int e) {
		return (e % 2 == 0) ? 0 : 1;
	}
}
