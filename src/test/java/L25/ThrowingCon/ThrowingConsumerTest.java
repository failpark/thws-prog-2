package L25.ThrowingCon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import java.util.*;
import java.util.function.Consumer;

public class ThrowingConsumerTest {

	@Test
	void testAcceptWithoutException() {
		List<Integer> values = new ArrayList<>();
		ThrowingConsumer<Integer, RuntimeException> consumer = values::add;

		assertDoesNotThrow(() -> consumer.accept(5));
		assertEquals(List.of(5), values);
	}

	@Test
	void testAcceptWithException() {
		ThrowingConsumer<String, IOException> consumer = s -> {
			if (s == null) throw new IOException("Null input");
		};

		assertDoesNotThrow(() -> consumer.accept("valid"));
		assertThrows(IOException.class, () -> consumer.accept(null));
	}

	@Test
	void testUncheckedWrapperWithoutException() {
		List<String> results = new ArrayList<>();
		ThrowingConsumer<String, Exception> appendLength = s -> results.add(s + ":" + s.length());
		Consumer<String> unchecked = ThrowingConsumer.unchecked(appendLength);

		unchecked.accept("test");
		unchecked.accept("hello");

		assertEquals(2, results.size());
		assertEquals("test:4", results.get(0));
		assertEquals("hello:5", results.get(1));
	}

	@Test
	void testUncheckedWrapperWithException() {
		ThrowingConsumer<String, IOException> consumer = s -> {
			if (s == null) throw new IOException("Null input");
		};
		Consumer<String> unchecked = ThrowingConsumer.unchecked(consumer);

		assertDoesNotThrow(() -> unchecked.accept("valid"));

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> unchecked.accept(null));
		assertTrue(thrown.getCause() instanceof IOException);
		assertEquals("Null input", thrown.getCause().getMessage());
	}

	@Test
	void testUncheckedWrapperWithCustomException() {
		class CustomException extends Exception {
			public CustomException(String message) {
				super(message);
			}
		}

		ThrowingConsumer<Integer, CustomException> consumer = i -> {
			if (i < 0) throw new CustomException("Negative value: " + i);
		};
		Consumer<Integer> unchecked = ThrowingConsumer.unchecked(consumer);

		assertDoesNotThrow(() -> unchecked.accept(10));

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> unchecked.accept(-5));
		assertTrue(thrown.getCause() instanceof CustomException);
		assertEquals("Negative value: -5", thrown.getCause().getMessage());
	}

	@Test
	void testCompositionWithStream() {
		List<String> processed = new ArrayList<>();
		List<String> errors = new ArrayList<>();

		ThrowingConsumer<String, Exception> riskyConsumer = s -> {
			if (s.length() > 3) {
				processed.add(s.toUpperCase());
			} else {
				throw new IllegalArgumentException("String too short: " + s);
			}
		};

		List<String> inputs = List.of("a", "test", "bc", "hello");

		inputs.forEach(s -> {
			try {
				riskyConsumer.accept(s);
			} catch (Exception e) {
				errors.add(s + ":" + e.getMessage());
			}
		});

		assertEquals(2, processed.size());
		assertEquals("TEST", processed.get(0));
		assertEquals("HELLO", processed.get(1));

		assertEquals(2, errors.size());
		assertTrue(errors.get(0).contains("String too short: a"));
		assertTrue(errors.get(1).contains("String too short: bc"));
	}
}