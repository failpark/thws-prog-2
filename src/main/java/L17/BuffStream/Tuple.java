package L17.BuffStream;

import java.io.*;

public class Tuple implements AutoCloseable {
	public InputStream in;
	public OutputStream out;

	public Tuple(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}

	public Tuple() {
		this.in = null;
		this.out = null;
	}

	public static Tuple get_base_streams(Tup<File, File> files) {
		Tuple stream = new Tuple();
		try {
			// we don't want to release the resources when we leave the try block
			// here we cannot use try-with-resources
			stream.in = new FileInputStream(files.a);
			stream.out = new FileOutputStream(files.b);
		} catch(IOException e) {
			stream.close();
			e.printStackTrace();
			System.exit(1);
		}
		return stream;
	}

	public static Tuple get_buf_streams(Tup<File, File> files) {
		Tuple streams = get_base_streams(files);
		return promote_buf_streams(streams);
	}

	public static Tuple promote_buf_streams(Tuple streams) {
		streams.in = new BufferedInputStream(streams.in);
		streams.out = new BufferedOutputStream(streams.out);
		return streams;
	}

	public void close() {
		try_close(this.in);
		this.in = null;
		try_close(this.out);
		this.out = null;
	}

	public static void try_close(AutoCloseable stream) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (Exception e) {
			// for my purposes this represents an unrecoverable error
			e.printStackTrace();
		}
	}
}
