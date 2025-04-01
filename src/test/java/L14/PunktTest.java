package L14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PunktTest {
	private static Punkt get_default() {
		Punkt std = new Punkt();
		std.x = 0;
		std.y = 0;
		return std;
	}

	private static void fail_ex() {
		fail("Runtime Exception expected");
	}

	private static void check(RuntimeException e) {
		assertEquals("Invalid", e.getMessage());
	}

	private static void run_test(int x, int y) {
		try {
			Punkt std = get_default();
			std.verschiebePunkt(x, y);
			fail_ex();
		} catch (RuntimeException e) {
			check(e);
		}
	}

	@Test
	public void test_neg() {
		run_test(-1, -1);
	}

	@Test
	public void test_neg_x() {
		run_test(-1, 1);
	}

	@Test
	public void test_neg_y() {
		run_test(0, -1);
	}

	@Test
	public void test_upper_x() {
		run_test(1921, 1);
	}

	@Test
	public void test_upper_y() {
		run_test(1, 1081);
	}

	@Test
	public void test_valid_x() {
		Punkt std = get_default();
		std.verschiebePunkt(1920, 0);
		assertEquals(1920, std.x);
	}

	@Test
	public void test_valid_y() {
		Punkt std = get_default();
		std.verschiebePunkt(0, 1080);
		assertEquals(1080, std.y);
	}
}
