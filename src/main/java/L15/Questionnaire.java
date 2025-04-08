package L15;

import java.util.ArrayList;
import java.util.Iterator;

public class Questionnaire {
	ArrayList<Quiz> quizzes = new ArrayList<>();

	public void add(Quiz q) {
		this.quizzes.add(q);
	}

	@Override
	public String toString() {
		if (this.quizzes.isEmpty()) return "";
		Iterator<Quiz> q = this.quizzes.iterator();
		String out = q.next().toString();
		for (Iterator<Quiz> it = q; it.hasNext(); ) {
			out += "\n-------\n" + it.next();
		}
		return out;
	}
}
