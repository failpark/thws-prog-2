package L14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PersonTest {
	@Test
	public void capital_firstname() {
		try {
			Person p = new Person("daniel", "Borgs", "Sanderheinrichsleitenweg", "20", 97074, "Würzi");
			fail("Runtime Exception expected");
		} catch (RuntimeException e) {
			assertEquals("Property should be capitalized", e.getMessage());
		}
	}
	@Test
	public void capital_lastname() {
		Person p = new Person("Daniel", "borgs", "Sanderheinrichsleitenweg", "20", 97074, "Würzi");
	}
	@Test
	public void capital_city() {
		try {
			Person p = new Person("Daniel", "Borgs", "Sanderheinrichsleitenweg", "20", 97074, "würzi");
			fail("Runtime Exception expected");
		} catch (RuntimeException e) {
			assertEquals("Property should be capitalized", e.getMessage());
		}
	}
	@Test
	public void street_number() {
		try {
			Person p = new Person("Daniel", "Borgs", "Sanderheinrichsleitenweg", "a20", 97074, "Würzi");
			fail("Runtime Exception expected");
		} catch (RuntimeException e) {
			assertEquals("Hausnummer muss mit Ziffer beginnen", e.getMessage());
		}
	}
	@Test
	public void valid_person() {
		Person p = new Person("Daniel", "Borgs", "Sanderheinrichsleitenweg", "20", 97074, "Würzi");
	}
}
