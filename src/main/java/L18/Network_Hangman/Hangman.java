package L18.Network_Hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
	private int tries = 15;
	private int curr = 0;
	private boolean finish = false;
	private char[] word;
	private static final String[] dictionary = new String[] {
			"Zephyr", "Lantern", "Harmony", "Cascade", "Velvet", "Orbit", "Whisker", "Echo", "Quicksand", "Mirage", "Ember", "Twilight", "Nimbus", "Flicker", "Mosaic", "Driftwood", "Galaxy", "Solstice", "Meadow", "Quiver"
	};
	// we only have this many tries
	private ArrayList<Character> inputs = new ArrayList<>();

	public Hangman() {
		this.word = dictionary[(int)(Math.random() * dictionary.length)].toLowerCase().toCharArray();
		System.out.println(this.word);
	}

	public boolean is_finished() {
		return finished_word();
	}

	private boolean finished_word() {
		for (char c : this.word) {
			if (!contains(c, this.inputs)) {
				System.out.println("false");
				return false;
			}
		}
		System.out.println("true");
		return true;
	}

	public boolean is_done() {
		return this.curr >= this.tries;
	}

	public String get_init_msg() {
		return "Gesucht ist: " + this.build_try();
	}

	public String get_formatted_run() {
		return (this.curr + 1) + ". Versuch: " + this.build_try();
	}

	public String get_formatted_sol() {
		return "Final solution after " + (this.curr + 1) + " tries: " + this.build_try();
	}

	public void add_char(char in) {
		if (!contains(in, this.word)) {
			this.curr += 1;
			return;
		}
		this.inputs.add(in);
	}

	public String build_try() {
		return String.valueOf(this._build_try());
	}

	private char[] _build_try() {
		char[] out = new char[this.word.length];
		boolean input_missing = false;
		for (int i = 0; i < this.word.length; i++) {
			if (contains(word[i], this.inputs)) {
				out[i] = word[i];
			} else {
				input_missing = true;
				out[i] = '_';
			}
		}
		if (!input_missing) this.finish = true;
		return out;
	}

	private static boolean contains(char needle, Iterable<Character> haystack) {
		for (char c : haystack) {
			if (needle == c) return true;
		}
		return false;
	}

	private static boolean contains(char needle, char[] haystack) {
		for (char c : haystack) {
			if (needle == c) return true;
		}
		return false;
	}
}