package L21.Exam;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Exam {
	private ArrayList<Question> questions = new ArrayList<>();
	static String PATH = "./src/main/java/L21/Exam";

	String readHeaderFromFile() {
		try (BufferedReader in = new BufferedReader(new FileReader(PATH + "/header.tpl"))) {
			return in.lines().collect(Collectors.joining("\n"));
		} catch (Exception e) {
			// somehow we're not supposed to propagate here?
			e.printStackTrace();
			return "";
		}
	}

	public Exam readQuestions() throws IOException {
		try (BufferedReader in = new BufferedReader(new FileReader(PATH + "/questions.csv"))) {
			in.lines().forEach(elem -> this.questions.add(Question.toQuestion(elem)));
		}
		return this;
	}

	public void toTest() throws IOException {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(PATH + "/test.tex"))) {
			out.write(this.readHeaderFromFile());
			out.newLine();
			for (Question q: this.questions) {
				out.write(q.toString());
				out.newLine();
			}
			out.write("\\end{document}");
		}
	}
}
