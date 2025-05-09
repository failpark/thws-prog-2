package L19.Network_Hangman;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

public class Server {
	public static final int PORT = 5001;
	public static void main(String[] args) {
		Hangman game = new Hangman();
		try(ServerSocket ss = new ServerSocket(Server.PORT);
			Socket connection = ss.accept();
			ObjectInputStream is = new ObjectInputStream(connection.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
		)
		{
			out.writeObject(game.get_init_msg());
			while(!game.is_done()) {
				try {
					char in = get_char(is);
					game.process(in);
				} catch(InputMismatchException e) {
					game.set_invalid_input();
					continue;
				}
				out.writeObject(game.get_res());
				out.flush();
			}
		} catch (FinishGameException e) {
			System.out.println("Exiting...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean is_exit(char in) {
		return '/' == in;
	}

	private static char get_char(ObjectInputStream ois) throws Exception {
		Guess in = (Guess) ois.readObject();
		if (is_exit(in.c)) throw new FinishGameException();
		return in.c;
	}
}
