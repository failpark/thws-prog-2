package L14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Kugelvolumen {
	public static double berechneKugelvolumen(double radius) {
//		Sinnvolle Maßnahme beim übergeben eines neg. radius:
//		- throw Exception
//		- absolute value nehmen
//		if (radius < 0) {
//			throw new RuntimeException("Keine negativen Werte!");
//		}
		return 4 / 3 * Math.PI * radius * radius * radius;
	}

	@Test
	public void testZero() {
		assertEquals(0, berechneKugelvolumen(0), 0.001);
	}

	@Test
	public void testOne() {
		assertEquals(3.141, berechneKugelvolumen(1), 0.001);
	}

	@Test
	public void testFive() {
		assertEquals(392.699, berechneKugelvolumen(5), 0.001);
	}

	@Test
	public void testNegOne() {
		assertEquals(-3.141, berechneKugelvolumen(-1), 0.001);
//		try {
//			berechneKugelvolumen(-1);
//			fail("Runtime Exception erwartet");
//		} catch (RuntimeException e) {
//			assertEquals("Keine negativen Werte!", e.getMessage());
//		}
	}
}
