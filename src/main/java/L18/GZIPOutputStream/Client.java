package L18.GZIPOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.GZIPOutputStream;

public class Client {
	public static void main(String[] args) throws IOException {
		try (Socket conn = new Socket("localhost", Server.PORT);
			 OutputStream out = new GZIPOutputStream(conn.getOutputStream())
		) {
			out.write("Hello World".getBytes());
		}
	}
}