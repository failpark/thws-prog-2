package L17.BuffStream;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Streams {
	public static void run_test(BiConsumer<Tuple, Tup<File, File>> f, Tuple streams, Tup<File, File> files) {
		int length = 10;
		long sum = 0;
		for (int i = 0; i < length; i++) {
			sum += run_timer(f, streams, files);
		}
		print_diff(sum / length);
	}

	private static long run_timer(BiConsumer<Tuple, Tup<File, File>> f, Tuple streams, Tup<File, File> files) {
		long start = System.nanoTime();
		f.accept(streams, files);
		long end = System.nanoTime();
		return end - start;
	}

	public static void run(Tuple streams, Tup<File, File> files) {
		int next_byte;
		// keep the resource connection alive
		try {
			do {
				next_byte = streams.in.read();
				if (next_byte != -1) streams.out.write(next_byte);
			} while (next_byte != -1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		cleanup(files);
	}

	public static void run_byte(Tuple streams, Tup<File, File> files) {
		byte[] buf = new byte[1024];
		int bytes_read;
		try {
			do {
				bytes_read = streams.in.read(buf);
				if (bytes_read != -1) streams.out.write(buf, 0, bytes_read);
			} while(bytes_read != -1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		cleanup(files);
	}

	private static void cleanup(Tup<File, File> files) {
		if (!files.b.exists()) {
			System.out.println("File does not exist");
			return;
		}
		if (files.a.length() != files.b.length()) System.out.println("File has not the same size");
//		if (!files.b.delete()) {
//			System.out.println("Could not delete file");
//			System.exit(1);
//		}
	}

	protected static void print_diff(long diff) {
		// getting the method name from the method reference is not supported it seems :c
		// we have to live with "The func"
		System.out.println("The func took: " + diff + " ns");
		System.out.println("The func took: " + TimeUnit.MICROSECONDS.convert(diff, TimeUnit.NANOSECONDS) + " micros");
		System.out.println("The func took: " + TimeUnit.MILLISECONDS.convert(diff, TimeUnit.NANOSECONDS) + " ms\n");
	}
}
