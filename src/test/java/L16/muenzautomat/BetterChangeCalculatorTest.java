package L16.muenzautomat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BetterChangeCalculatorTest {
	@Test
	public void same_value_test() {
		ChangeCalculator t = new BetterChangeCalculator();
		Coin[] coins = Coin.values();
		int cent = 99;
		int euro = 0;
		int[] change = t.getChange(euro, cent);

		int check = 0;
		for (int i = 0; i < 7; i++) {
			check += (coins[i].value * change[i]);
		}
		assertEquals(cent, check);
	}

	public void min_distribution_test() {
		ChangeCalculator t = new BetterChangeCalculator();
		int euro = 5;
		int cent = 66;
		int[] solution = new int[]{
				1, // 1
				0, // 2
				1, // 5
				1, // 10
				0, // 20
				1, // 50
				1, // 1
				2  // 2
		};
		assertArrayEquals(solution, t.getChange(euro, cent));
	}
}
