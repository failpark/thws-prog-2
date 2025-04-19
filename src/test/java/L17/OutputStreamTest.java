package L17;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamTest {
	private static FileOutputStream get_stream(String file) throws FileNotFoundException {
		return new FileOutputStream(file);
	}
	private static FileOutputStream get_stream() throws FileNotFoundException {
		return get_stream("./target/stream");
	}

	private static FileOutputStream get_ro_stream() throws FileNotFoundException {
		String filename = "./target/stream_r/";
		File dir = new File(filename);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// this didn't work :c
//		if (!file.setReadOnly()) {
//			throw new RuntimeException("Could not set file to read only");
//		}
//		file.deleteOnExit();
		return new FileOutputStream(filename);
	}

	private static byte[] get_byte() {
		return new byte[]{'a'};
	}

	@Test
	public void test_valid() throws IOException {
		FileOutputStream stream = get_stream();
		stream.write(get_byte(), 0, 1);
	}

	@Test
	public void test_big_off() throws FileNotFoundException {
		FileOutputStream stream = get_stream();
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> stream.write(get_byte(), get_byte().length + 4, get_byte().length)
		);
	}

	@Test
	public void test_length() throws FileNotFoundException {
		FileOutputStream stream = get_stream();
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> stream.write(get_byte(),0, 30)
		);
	}

	@Test
	public void test_neg_off() throws FileNotFoundException {
		FileOutputStream stream = get_stream();
		assertThrows(
				IndexOutOfBoundsException.class,
				() -> stream.write(get_byte(), -1, get_byte().length)
		);
	}

	@Test
	public void test_read_only() {
		assertThrows(
				FileNotFoundException.class,
				OutputStreamTest::get_ro_stream
		);
	}
}
