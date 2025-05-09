package L21.Exam;

import org.junit.jupiter.api.Test;

import java.io.*;

public class ExamTest {
	@Test
	public void existsTest() throws IOException {
		new Exam()
				// returns exam
				.readQuestions()
				// terminates with void --> fluid interface?
				.toTest();
		new FileReader(Exam.PATH + "/test.tex").close();
	}

}
