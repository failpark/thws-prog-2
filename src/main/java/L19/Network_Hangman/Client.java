package L19.Network_Hangman;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		final String HOST = "localhost";
		Scanner scanner = new Scanner(System.in);

		try (Socket conn = new Socket(HOST, Server.PORT);
			 ObjectOutputStream os = new ObjectOutputStream(conn.getOutputStream());
			 ObjectInputStream is = new ObjectInputStream(conn.getInputStream());
		) {
//			Response res = get_res(is);
//			System.out.println(res.msg);
			while (true) {
				Response res = get_res(is);
				System.out.println(res.msg);
				if (GameState.should_exit(res.state)) break;
				char in = scanner.nextLine().charAt(0);
				write_obj(in, os);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Exiting ...");
	}

	private static Response get_res(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		Response in = (Response) ois.readObject();
		return in;
	}

	private static void write_obj(char guess, ObjectOutputStream oos) throws IOException {
		oos.writeObject(new Guess(guess));
		oos.flush();
	}
}
