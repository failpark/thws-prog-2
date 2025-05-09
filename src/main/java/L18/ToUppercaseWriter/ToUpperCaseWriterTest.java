package L18.ToUppercaseWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToUpperCaseWriterTest {
	public void write(char c, String expected) {
		try (
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(baos);
				ToUpperCaseWriter writer = new ToUpperCaseWriter(osw);
		) {
			writer.write(c);
			writer.flush();
			String uppercase = baos.toString();
			assertEquals(expected, uppercase);
		} catch (IOException e) {
			fail("IOException" + e.getMessage());
		}
	}

	@Test
	// technically redundant since this is already contained in the first 128 ASCII vals
	public void charTest() {
		write('a', "A");
	}

	@Test
	// technically redundant since this is already contained in the first 128 ASCII vals
	public void numTest() {
		write('1', "1");
	}

	@Test
	public void ASCIInoChangeTest() {
		for (int i = 0; i < (int)'a'; i++) {
			write((char)i, String.valueOf((char)i));
		}
		for (int i = ((int)'z' + 1); i < 128; i++) {
			write((char)i, String.valueOf((char)i));
		}
	}

	@Test
	public void ASCIIChangeTest() {
		int diff = (int)'a' - (int)'A';
		for (int i = 'a'; i <= (int)'z'; i++) {
			write((char) i, String.valueOf((char)(i - diff)));
		}
	}
}
