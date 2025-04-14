package L16.cyborg;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.*;

public class AutofahrenTest {
	public static class Tuple<X, Y> {
		public final X a;
		public final Y b;
		public Tuple(X a, Y b) {
			this.a = a;
			this.b = b;
		}
	}

	private static Stream<Arguments> arg_provider() {
		Tuple<Gefahr, Reaktion>[] solution = provideTestMatrix();
		return Stream.of(
				Arguments.arguments(new MenschImpl(), solution),
				Arguments.arguments(new RoboterImpl(), solution),
				Arguments.arguments(new Cyborg(), solution)
		);
	}

	// A simple pair would be nice but oh well...
	private static Tuple<Gefahr, Reaktion>[] provideTestMatrix() {
		// DANGER ZONE. We assume that the Enums are sorted properly but they may not be
		// But lazy town wins here. 🤷‍♀️
		Gefahr[] d = Gefahr.values();
		Reaktion[] r = Reaktion.values();
		Tuple[] out = new Tuple[d.length];
		// zip would be so nice here wth
		// if anyone ever reads this: Just use Rust. Its so much better
		for (int i = 0; i < out.length; i++) {
			out[i] = new Tuple<Gefahr, Reaktion>(d[i], r[i]);
		}
		return out;
	}

	private static void run_tests(Autofahren driver, Tuple<Gefahr, Reaktion>[] solution) {
		for (Tuple<Gefahr, Reaktion> sol : solution) {
			assertEquals(sol.b, driver.entscheide(sol.a));
		}
	}

	@ParameterizedTest
	@MethodSource("arg_provider")
	public void drive_test(Autofahren driver, Tuple<Gefahr, Reaktion>[] solution) {
		run_tests(driver, solution);
	}

	@RepeatedTest(value = 100, failureThreshold =  40)
	public void rand_test() {
		assertFalse(MenschImpl.is_undecided());
	}
}
