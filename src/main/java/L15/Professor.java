package L15;

public class Professor extends Person {
	public Professor(String subject) {
		super(subject);
	}

	@Override
	public String toString() {
		return "Der Professor unterrichtet " + this.subject;
	}

	public void gibTaetigkeitAus() {
		System.out.println(this);
	}
}
