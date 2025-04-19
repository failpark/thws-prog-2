package L17.BuffStream;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Tup<File, File> files = new Tup<>(
//				prompt_user(),
				new File("./target/test.mp3"),
				new File("./target/L17_copy.mp3")
		);
		Tuple base = Tuple.get_base_streams(files);
		Streams.run_test(Streams::run_byte, base, files);
		Streams.run_test(Streams::run, base, files);
		Streams.run_test(Streams::run, Tuple.promote_buf_streams(base), files);
		System.out.println("-------------------");
		StreamsRessource.run_test(StreamsRessource::run, files, false);
		StreamsRessource.run_test(StreamsRessource::run, files, true);
		StreamsRessource.run_test_byte(files);

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
