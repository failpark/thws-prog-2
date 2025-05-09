package L25.MapReduce;

import java.util.function.Function;

public interface ThrowingFunction<T, R, E extends Exception> {
	R apply(T t) throws E;
	static <T, R, E extends Exception>Function<T, R> unchecked(ThrowingFunction<T, R, E> func) {
		return t -> {
			try {
				return func.apply(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
