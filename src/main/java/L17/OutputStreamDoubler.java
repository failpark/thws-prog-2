package L17;

import java.io.*;

public class OutputStreamDoubler extends OutputStream {
	OutputStream a;
	OutputStream b;
	public OutputStreamDoubler(OutputStream a, OutputStream b) {
		this.a = a;
		this.b = b;
	}

	private void write_general(OutputStream stream, int b) {
		try {
			stream.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(int b) {
		write_general(this.a, b);
		write_general(this.b, b);
	}

	private boolean try_close(OutputStream stream) {
		try {
			stream.close();
			return false;
		} catch(IOException e) {
			return true;
		}
	}

	public void close() throws IOException {
		boolean stream1 = try_close(this.a);
		boolean stream2 = try_close(this.b);
		String out = "Folgende Stream(s) konnten nicht geschlossen werden: ";
		String append = "";
		if (stream1 && stream2) {
			append = "1 & 2";
		} else if (stream1) {
			append = "1";
		} else if (stream2) {
			append = "2";
		} else {
			return;
		}
		throw new IOException(out + append);
	}

	public static void main(String[] args) throws IOException {
		OutputStream out1 = new FileOutputStream("./target/test1.txt");
		OutputStream out2 = new FileOutputStream("./target/test2.txt");
		try(
			InputStream fis = new FileInputStream("./target/test.txt");
			OutputStream out = new OutputStreamDoubler(out1, out2);
		) {
			int content;
			while((content = fis.read()) != -1) {
				out.write(content);
			}
		}
	}
}
