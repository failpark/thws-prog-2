package L17.BuffStream;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Tup<File, File> files = new Tup<>(
//				prompt_user(),
				new File("./target/test.mp3"),
				new File("./target/L17_copy.mp3")
		);
		Tuple base = Tuple.get_base_streams(files);
		// I wanted to see what the difference was between setting the lock for the files once
		// and then reading/writing vs getting the lock every time
		// turns out there IS a difference. Setting the lock beforehand makes buf und unbuff byte arr basically equally fast
		// vs setting the lock every time somehow makes the buf ~4 times slower
		// would be interesting to see ~~WHY~~ but that's a to-do for future daniel lol
		long diff1 = Streams.run_test(Streams::run, base, files);
		long diff2 = Streams.run_test(Streams::run_byte, base, files);
		long diff3 = Streams.run_test(Streams::run, Tuple.promote_buf_streams(base), files);
		System.out.println();
		System.out.println("Shortest Stream (buf) as base:");
		System.out.println("Unbuffered: " + diff1 / (float)diff3 + " times slower");
		if (diff2 < diff3) {
			System.out.println("Unbuffered Array: " + diff2 / (float)diff3 + " times slower");
		} else {
			System.out.println("Unbuffered Array: " + diff3 / (float)diff2 + " times faster");
		}
		System.out.println("-------------------");
		diff1 = StreamsRessource.run_test(StreamsRessource::run, files, false);
		diff2 = StreamsRessource.run_test(StreamsRessource::run, files, true);
		diff3 = StreamsRessource.run_test_byte(files);
		System.out.println();
		System.out.println("Shortest Stream (unbuf arr) as base:");
		System.out.println("Unbuffered: " + diff1 / (float)diff3 + " times slower");
		System.out.println("Buffered: " + diff2 / (float)diff3 + " times slower");

		base.close();
	}

	private static File prompt_user() {
		Scanner scanner = new Scanner(System.in);
		File file;
		while(true) {
			System.out.println("Gib einen Pfad zu einer mp3 Datei");
			String path = scanner.nextLine();
			if (path.isEmpty()) System.exit(0);
			file = new File(path);
			if (file.exists() && file.isFile() && has_mp3_ext(file.getAbsolutePath())) {
				scanner.close();
				return file;
			}
			System.err.println("Datei ist ungültig");
		}
	}

	private static boolean has_mp3_ext(String filename) {
		return filename.substring(filename.lastIndexOf('.') + 1).equals("mp3");
	}
}
