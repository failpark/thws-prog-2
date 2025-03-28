package L15;

public class Questionnaire {
	Quiz root;

	public Questionnaire(Quiz root) {
		this.root = root;
	}

	@Override
	public String toString() {
		String out = "";
		Quiz iter = this.root;
		while (iter != null) {
			out += "\n-------\n" + iter;
			iter = iter.next;
		}
		return out;
	}
}
