package L17.BuffStream;

import java.io.File;
import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class StreamsRessource extends Streams {
	public static void run_test(BiConsumer<Tup<File, File>, Boolean> f, Tup<File, File> files, boolean promote) {
		int length = 10;
		long sum = 0;
		for (int i = 0; i < length; i++) {
			sum += run_timer(f, files, promote);
			System.out.println("running");
		}
		Streams.print_diff(sum / length);
	}

	private static long run_timer(BiConsumer<Tup<File, File>, Boolean> f, Tup<File, File> files, boolean promote) {
		long start = System.nanoTime();
		f.accept(files, promote);
		long end = System.nanoTime();
		return end - start;
	}

	private static long run_timer_byte(Consumer<Tup<File, File>> f, Tup<File, File> files) {
		long start = System.nanoTime();
		f.accept(files);
		long end = System.nanoTime();
		return end - start;
	}

	public static void run_test_byte(Tup<File, File> files) {
		int length = 10;
		long sum = 0;
		for (int i = 0; i < length; i++) {
			sum += run_timer_byte(StreamsRessource::run_byte, files);
		}
		Streams.print_diff(sum / length);
	}

	public static void run(Tup<File, File> files, boolean promote) {
		int next_byte;
		Tuple streams;
		if (promote) {
			streams = Tuple.get_buf_streams(files);
		} else {
			streams = Tuple.get_base_streams(files);
		}
		// mimimi... var in try-resource should be final .-.
		try(streams) {
			do {
				next_byte = streams.in.read();
				if (next_byte != -1) streams.out.write(next_byte);
			} while (next_byte != -1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void run_byte(Tup<File, File> files) {
		byte[] buf = new byte[1024];
		int bytes_read;
		try(Tuple streams = Tuple.get_base_streams(files)) {
			do {
				bytes_read = streams.in.read(buf);
				if (bytes_read != -1) streams.out.write(buf, 0, bytes_read);
			} while(bytes_read != -1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
