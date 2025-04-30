package L18.Network_Hangman;

import java.io.*;
import java.net.*;
import java.util.InputMismatchException;

public class Server {
	public static final int PORT = 5001;
	public static void main(String[] args) {
		Hangman game = new Hangman();
		try(ServerSocket ss = new ServerSocket(Server.PORT);
			Socket connection = ss.accept();
			InputStream is = connection.getInputStream();
			OutStreamWrap out = new OutStreamWrap(connection.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		)
		{
			out.write(game.get_init_msg());
			while(!game.is_done()) {
				out.write(game.get_formatted_run());
				try {
					char in = get_char(br);
					game.add_char(in);
				} catch(InputMismatchException e) {
//					out.write("Only write one char or `exit`");
					continue;
				}
				if (game.is_finished()) {
					out.write(game.get_formatted_sol());
					break;
				}
			}
		} catch (FinishGameException e) {
			System.out.println("Exiting...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean is_exit(String in) {
		return "exit".equals(in);
	}

	private static char get_char(BufferedReader br) throws InputMismatchException, IOException, FinishGameException {
		String in = br.readLine();
		if (is_exit(in)) throw new FinishGameException();
		if (in.length() != 1) throw new InputMismatchException();
		return in.charAt(0);
	}
}
