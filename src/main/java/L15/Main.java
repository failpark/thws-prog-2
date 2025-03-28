package L15;

public class Main {
	public static void main(String[] args) {
//		person();
		quiz();
	}

	static void quiz() {
		Quiz text = new TextQuiz("Was ist die Hauptstadt von Deutschland?", "Berlin");
		Quiz multiple = new MultipleChoiceQuiz("Wie viele Protonen hat ein Wasserstoff-Atom?", new String[]{"4", "2", "1", "0"}, 2);
		text.next = multiple;
		Questionnaire out = new Questionnaire(text);
		System.out.println(out);
	}

	static void person() {
		Person[] personen = new Person[100];
		String subject = "Programmieren";
		for (int i = 0; i < personen.length; i++) {
			Person tmp;
			if (i % 2 == 0) {
				tmp = new Student(subject);
			} else {
				tmp = new Professor(subject);
			}
			personen[i] = tmp;
			tmp.gibTaetigkeitAus();
		}
	}
}
