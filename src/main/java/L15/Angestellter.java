package L15;

import java.util.GregorianCalendar;

public class Angestellter {
	String nachname, vorname;
	int id;
	float grundgehalt;
	float gehaltsfaktor = 1;
	GregorianCalendar geburtstag;

	public Angestellter(String nachname, String vorname, int id, float grundgehalt, GregorianCalendar geburtstag) {
		this.nachname = nachname;
		this.vorname = vorname;
		this.id = id;
		this.grundgehalt = grundgehalt;
		this.geburtstag = geburtstag;
	}

	public float get_gehalt() {
		return this.grundgehalt * this.gehaltsfaktor;
	}

	public static GregorianCalendar gen_geburtstag(int year, int month, int day) {
		return new GregorianCalendar(year, month, day);
	}
}
