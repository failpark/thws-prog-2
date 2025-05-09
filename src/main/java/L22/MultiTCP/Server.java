package L22.MultiTCP;

import L19.Network_Hangman.Guess;
import L22.Prime.PrimzahlThread;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Server {
	public static final int PORT = 5001;
	private static class PrimeThread extends Thread {
		private Socket conn;
		private Map<Integer, Boolean> result = new HashMap<>();

		public PrimeThread(Socket conn) {
			this.conn = conn;
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
			try (
				ObjectInputStream ois = new ObjectInputStream(this.conn.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(this.conn.getOutputStream());
			) {
			List<Integer> ints = (List<Integer>) ois.readObject();
			this.result = ints
//					.stream()
					.parallelStream()
					.collect(Collectors.toMap(
//						Integer::valueOf,
//						Function.identity(),
							i -> i, // is the same as Function.identity(); key mapper
							PrimeThread::is_prime
					));
			oos.writeObject(this.result);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		public Map<Integer, Boolean> get_result() {
			return this.result;
		}
	}

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(PORT)) {
			ArrayList<PrimeThread> threads = new ArrayList<>();
			while(true) {
				Socket conn = ss.accept();
				PrimeThread t = new PrimeThread(conn);
				t.start();
				threads.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
