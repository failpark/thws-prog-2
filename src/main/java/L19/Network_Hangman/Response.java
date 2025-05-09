package L19.Network_Hangman;

public class Response implements java.io.Serializable {
	public String msg = "";
	public GameState state = GameState.invalid_input;
	public char guess;
	public Response() {}
	public Response (String msg) {
		this.msg = msg;
	}
}
