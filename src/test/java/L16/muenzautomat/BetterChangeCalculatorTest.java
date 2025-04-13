package L16.muenzautomat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BetterChangeCalculatorTest {
	ChangeCalculator calc = new BetterChangeCalculator();

	@Test
	public void same_value_test() {
		Coin[] coins = Coin.values();
		int cent = 99;
		int euro = 0;
		int[] change = calc.getChange(euro, cent);

		int check = 0;
		for (int i = 0; i < 7; i++) {
			check += (coins[i].value * change[i]);
		}
		assertEquals(cent, check);
	}

	public void min_distribution_test() {
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
		assertArrayEquals(solution, calc.getChange(euro, cent));
	}

	@Test
	public void testChangeFor99Cent() {
		int[] expected = {0, 2, 1, 0, 2, 1, 0, 0};
		assertArrayEquals(expected, calc.getChange(0, 99), "Fehler bei 0,99 €");
	}

	@Test
	public void testChangeFor388cent() {
		int[] expected = {1, 1, 1, 1, 1, 1, 1, 1};
		assertArrayEquals(expected, calc.getChange(3, 88));
	}

	@Test
	public void testChangeForZero() {
		int[] expected = {0, 0, 0, 0, 0, 0, 0, 0}; // 0 €
		assertArrayEquals(expected, calc.getChange(0, 0), "Fehler bei 0 €");
	}

	@Test
	public void testChangeFor200Cent() {
		int[] expected = {0, 0, 0, 0, 0, 0, 0, 1}; // 2,00 €
		assertArrayEquals(expected, calc.getChange(2, 0), "Fehler bei 2,00 €");
	}
}
