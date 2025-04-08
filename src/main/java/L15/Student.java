package L15;

public class Student extends Person {
	public Student(String subject) {
		super(subject);
	}

	@Override
	public String toString() {
		return "Der Student besucht das Fach " + this.subject;
	}

	public void gibTaetigkeitAus() {
		System.out.println(this);
	}
}
