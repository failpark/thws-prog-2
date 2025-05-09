package L18.Network_Hangman;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		final String HOST = "localhost";
		Scanner scanner = new Scanner(System.in);

		try (Socket conn = new Socket(HOST, Server.PORT);
			 OutStreamWrap os = new OutStreamWrap(conn.getOutputStream());
			 InputStream is = conn.getInputStream();
			 BufferedReader br = new BufferedReader(new InputStreamReader(is));
		) {
			String res = br.readLine();
			System.out.println(res);
			while (true) {
				res = br.readLine();
				if (res == null) break;
				System.out.println(res);
				String in = scanner.nextLine();
				os.write(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Exiting ...");
	}
}
