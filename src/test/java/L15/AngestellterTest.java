package L15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AngestellterTest {
	@Test
	public void gehalt_test() {
		Angestellter a = new Angestellter(
				"Mustermann",
				"Max",
				1,
				3000,
				Angestellter.gen_geburtstag(1900, 10, 17)
		);
		assertEquals(3000f, a.get_gehalt());
	}

	@Test
	public void leiter_test() {
		Abteilungsleiter a = new Abteilungsleiter(
				"Mustermann",
				"Max",
				1,
				3000,
				Abteilungsleiter.gen_geburtstag(1900, 10, 17)
		);
		assertEquals(6000f, a.get_gehalt());
	}

	@Test
	public void promotion_test() {
		Abteilungsleiter a = new Abteilungsleiter(
				"Mustermann",
				"Max",
				1,
				3000,
				Abteilungsleiter.gen_geburtstag(1900, 10, 17)
		);

		Angestellter b = new Angestellter(
				"Mustermann",
				"Max",
				1,
				3000,
				Angestellter.gen_geburtstag(1900, 10, 17)
		);
		assertEquals(3000f, b.get_gehalt());
		a.promote(b);
		assertEquals(3300f, b.get_gehalt());
	}
}
