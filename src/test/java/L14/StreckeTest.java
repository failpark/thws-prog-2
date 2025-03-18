package L14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StreckeTest {
	private static void fail_strecke(int min, int max, Strecke check) {
		fail(String.format(
				"A should contain %s but contains: %s\n" +
				"B should contain %s but contains %s",
				min,
				check.A,
				max,
				check.B
		));
	}

	@Test
	public void is_sorted_max_min() {
		int min = 1;
		int max = 8;
		Strecke check = new Strecke(max, min);

		if (check.A == min && check.B == max) {
			return;
		}
		fail_strecke(min, max, check);
	}
	@Test
	public void is_sorted_min_max() {
		int min = 1;
		int max = 8;
		Strecke check = new Strecke(min, max);

		if (check.A == min && check.B == max) {
			return;
		}
		fail_strecke(min, max, check);
	}
	@Test
	public void valid_output() {
		Strecke s = new Strecke(3, 5);
		assertEquals("3--5", s.toString());
		s.A = 2;
		s.B = 8;
		assertEquals("2------8", s.toString());
		s.A = 4;
		s.B = 4;
		assertEquals("4", s.toString());
	}

	@Test
	public void intersects() {
		Strecke left = new Strecke(3, 5);
		Strecke right = new Strecke(5, 8);
		assertFalse(Strecke.intersects(left, right));
		assertFalse(Strecke.intersects(right, left));
		left.B = 6;
		assertTrue(Strecke.intersects(left, right));
		assertTrue(Strecke.intersects(right, left));
		left.B = 3;
		assertFalse(Strecke.intersects(left, right));
		assertFalse(Strecke.intersects(right, left));
		left.A = 4;
		left.B = 4;
		right.A = 4;
		right.B = 4;
		assertFalse(Strecke.intersects(left, right));
		assertFalse(Strecke.intersects(right, left));
	}
}
