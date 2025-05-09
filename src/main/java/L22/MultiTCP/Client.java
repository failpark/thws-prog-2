package L22.MultiTCP;

import L19.Network_Hangman.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;
import java.util.stream.IntStream;

public class Client {
	private static final String HOST = "localhost";
	private static int get_int(Scanner in) {
		while(true) {
			try {
				return Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("Please provide a valid num.");
			}
		}
	}

	private static List<Integer> get_range(int start, int end) {
		// boxed because IntStream makes int but for List we need boxed Integer
		return IntStream.rangeClosed(start, end).boxed().toList();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please provide a start int");
		int start = get_int(scanner);
		System.out.println("Please provide a end int");
		int end = get_int(scanner);
		scanner.close();
		List<Integer> range = get_range(start, end);
		try (Socket conn = new Socket(HOST, Server.PORT);
			 ObjectOutputStream out = new ObjectOutputStream(conn.getOutputStream());
			 ObjectInputStream in = new ObjectInputStream(conn.getInputStream());
		) {
			out.writeObject(range);
			Map<Integer, Boolean> primes = (Map<Integer, Boolean>) in.readObject();
			primes.entrySet()
					.stream()
					.filter(Map.Entry::getValue)
					.sorted(Map.Entry.comparingByKey())
					.forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
