package L15;

public class Student extends Person {
	public Student(String subject) {
		super(subject);
	}

	public void gibTaetigkeitAus() {
		System.out.println("Der Student besucht das Fach " + this.subject);
	}
}
