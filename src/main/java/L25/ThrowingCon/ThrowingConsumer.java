package L25.ThrowingCon;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {
	void accept(T t) throws E;
	static <T, E extends Exception> Consumer<T> unchecked(ThrowingConsumer<T, E> func) {
		return t -> {
			try {
				// Consumer does not return anything
				func.accept(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
