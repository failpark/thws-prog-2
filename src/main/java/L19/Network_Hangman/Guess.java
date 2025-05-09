package L19.Network_Hangman;

import java.io.Serializable;

public class Guess implements Serializable {
	public char c;
	public Guess(char c) {
		this.c = c;
	}
}
