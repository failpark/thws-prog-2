package L20.SMS;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SMSConverterTest {
	@Test
	public void validTest() throws IllegalTelephoneNumberException {
		assertEquals("325858238349", SMSConverter.convert("FAKULTAETFIW"));
	}

	@Test
	public void invalidTest() {
		assertThrows(
				IllegalTelephoneNumberException.class,
				() -> SMSConverter.convert("---")
		);
	}
}
