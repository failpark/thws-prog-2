package L18.Network_Hangman;

import java.io.*;
public class OutStreamWrap extends OutputStream {
	OutputStream out;

	public OutStreamWrap(OutputStream out) {
		this.out = out;
	}

	public void write(String out) throws IOException {
		this.out.write((out + '\n').getBytes());
		this.flush();
	}

	public void write(int b) throws IOException {
		this.out.write(b);
	}

	public void flush() throws IOException {
		this.out.flush();
	}

	// why is in not necessary to implement this?
	// I could remove this and won't get an error
	// Java would just accept this
	// that's just ass ngl
	public void close() throws IOException {
		this.out.close();
	}
}
