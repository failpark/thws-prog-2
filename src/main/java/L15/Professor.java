package L15;

public class Professor extends Person {
	public Professor(String subject) {
		super(subject);
	}

	public void gibTaetigkeitAus() {
		System.out.println("Der Professor unterrichtet " + this.subject);
	}
}
