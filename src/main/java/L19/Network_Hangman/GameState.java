package L19.Network_Hangman;

public enum GameState implements java.io.Serializable {
	invalid_input,
	correct_guess,
	wrong_guess,
	done,
	// word guessed implies finished
	word_guessed;

	public static boolean should_exit(GameState state) {
		return switch (state) {
			case done, word_guessed -> true;
			default -> false;
		};
	}
}
