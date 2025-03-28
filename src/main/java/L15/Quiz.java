package L15;

public abstract class Quiz {
	String question;
	String solution;
	Quiz next;

	public Quiz(String question, String solution) {
		this.question = question;
		this.solution = solution;
	}

	String get_formatted_question() {
		return "Fragentext:\n" + this.question;
	}

	String get_formatted_solution() {
		return "Antwort:\n\n";
	}

	@Override
	public String toString() {
		return this.get_formatted_question() + "\n\n" + this.get_formatted_solution();
	}

	public void print_quiz() {
		System.out.println(this.toString());
	}
}
