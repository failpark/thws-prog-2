package L19;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BrowserTest {
	@Test
	public void EmptyTest() throws MalformedURLException, URISyntaxException {
		assertEquals(Optional.empty(), Browser.back(true));
	}

	@Test
	public void URLTest() throws MalformedURLException, URISyntaxException {
		assertEquals("https://duckduckgo.com", Browser.back(false).get().toString());
	}
}
