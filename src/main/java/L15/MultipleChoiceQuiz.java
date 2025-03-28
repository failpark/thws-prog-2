package L15;

public class MultipleChoiceQuiz extends Quiz {
	String[] choices;

	public MultipleChoiceQuiz(String frage, String[] choices, int solution_pos) {
		super(frage, choices[solution_pos]);
		this.choices = choices;
	}

	@Override
	String get_formatted_solution() {
		String tmp = "";
		char choice = 'A';
		for (String s : this.choices) {
			tmp += choice++ +": " + s + "\n";
		}
		return "Antwortmöglichkeiten:\n" + tmp;
	}
}
