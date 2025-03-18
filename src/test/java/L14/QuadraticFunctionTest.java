package L14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadraticFunctionTest {
	@Test
	public void test() {
		QuadraticFunction c = new QuadraticFunction(1, 0, -4);
		double[] res = new double[]{2, -2};
		assertArrayEquals(res, c.roots());
	}
	@Test
	public void test2() {
		QuadraticFunction c = new QuadraticFunction(1, -3, -10);
		double[] res = new double[]{5, -2};
		assertArrayEquals(res, c.roots());
	}
}
