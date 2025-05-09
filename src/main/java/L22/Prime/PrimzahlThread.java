package L22.Prime;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.*;

public class PrimzahlThread extends Thread {
	private List<Integer> test_ints;
	private Map<Integer, Boolean> result = new HashMap<>();

	public PrimzahlThread(List<Integer> test_ints) {
		this.test_ints = test_ints;
	}

	public static boolean is_prime(int n) {
		if (n < 2) return false;
		if (n == 2 || n == 3) return true;
		if (n % 2 == 0 || n % 3 == 0) return false;
		int sqrtN = (int) Math.sqrt(n) + 1;
		for (int i = 6; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
		}
		return true;
	}

	public void run() {
		this.result = test_ints
//				.stream()
				.parallelStream()
				.collect(Collectors.toMap(
//						Integer::valueOf,
//						Function.identity(),
						i -> i, // is the same as Function.identity(); key mapper
						PrimzahlThread::is_prime
				));
	}

	public Map<Integer, Boolean> get_result() {
		return this.result;
	}

	private static List<Integer> get_range(int start, int end) {
		// boxed because IntStream makes int but for List we need boxed Integer
		return IntStream.rangeClosed(start, end).boxed().toList();
	}

	public static void main(String[] args) throws InterruptedException {
		// has to be even
		PrimzahlThread[] t = new PrimzahlThread[4];
		int steps = 1_000_000 / t.length;
		for (int i = 0; i < t.length; i++) {
			t[i] = new PrimzahlThread(get_range(steps * i, steps * (i + 1)));
			t[i].start();
		}
		for (PrimzahlThread th : t) {
			th.join();
		}
		// Provides a mut Container with ref immutability
		// java requires var in lambda should be final or effectively final
		// could also use AtomicLong
		long[] counter = new long[1];
		Arrays.stream(t)
				.flatMap(i -> i.get_result().entrySet().stream())
				// comment this and the assert out if you are presenting
				.filter(Map.Entry::getValue)
				.sorted(Map.Entry.comparingByKey())
				// modify array content not array ref
				// peek since we don't want to consume
				.peek(entry -> counter[0]++)
//				.sorted((e1, e2) -> Integer.compare(e1.getKey(), e2.getKey()))
				.forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
		// sanity check
		// in 1_000_000 there are 78,498 primes
		assert counter[0] == 78_498;
	}
}
