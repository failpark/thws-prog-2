package L19.Network_Hangman;

import java.util.ArrayList;

public class Hangman {
	private int tries = 15;
	private int curr = 1;
	private char[] word;
	private static final String[] dictionary = new String[] {
			"Zephyr", "Lantern", "Harmony", "Cascade", "Velvet", "Orbit", "Whisker", "Echo", "Quicksand", "Mirage", "Ember", "Twilight", "Nimbus", "Flicker", "Mosaic", "Driftwood", "Galaxy", "Solstice", "Meadow", "Quiver"
	};
	// we only have this many tries
	private ArrayList<Character> inputs = new ArrayList<>();
	private Response res;

	public Hangman() {
		this.word = dictionary[(int)(Math.random() * dictionary.length)].toLowerCase().toCharArray();
		System.out.println(this.word);
	}

	public Response get_res() {
		return this.res;
	}

	public void set_invalid_input() {
		this.res = new Response();
		this.res.state = GameState.invalid_input;
		this.set_res_msg();
	}

	private boolean guessed_word() {
		for (char c : this.word) {
			if (!contains(c, this.inputs)) {
				return false;
			}
		}
		return true;
	}

	public boolean is_done() {
		return this.curr >= this.tries;
	}

	public Response get_init_msg() {
		return new Response("Gesucht ist: " + this.build_try());
	}

	public String get_formatted_run() {
		return this.curr + ". Versuch: " + this.build_try();
	}

	public String get_formatted_sol() {
		return "Final solution after " + this.curr + " tries: " + this.build_try();
	}

	private String get_formatted_exit() {
		return ":c you didn't guess the word: " + new String(this.word) + " in time";
	}

	private String get_formatted_invalid_input() {
		return "Only write one char or `exit`";
	}

	private void set_res_msg() {
		this.res.msg = switch(this.res.state) {
			case GameState.word_guessed -> this.get_formatted_sol();
			case GameState.done -> this.get_formatted_exit();
			case GameState.invalid_input -> this.get_formatted_invalid_input();
			default -> this.get_formatted_run();
		};
	}

	public void process(char in) {
		this.res = new Response();
		this.process_guess(in);
		this.set_res_msg();
	}

	private void process_guess(char in) {
		this.res = new Response();
		this.res.guess = in;
		if (!contains(in, this.word)) {
			this.res.state = GameState.wrong_guess;
			this.curr += 1;
			return;
		}
		this.inputs.add(in);
		if (this.guessed_word()) {
			this.res.state = GameState.word_guessed;
		} else if (this.is_done()) {
			this.res.state = GameState.done;
		} else {
			this.res.state = GameState.correct_guess;
		}
	}

	public String build_try() {
		return String.valueOf(this._build_try());
	}

	private char[] _build_try() {
		char[] out = new char[this.word.length];
		for (int i = 0; i < this.word.length; i++) {
			if (contains(word[i], this.inputs)) {
				out[i] = word[i];
			} else {
				out[i] = '_';
			}
		}
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