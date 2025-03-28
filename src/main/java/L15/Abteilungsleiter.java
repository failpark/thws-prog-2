package L15;

import java.util.GregorianCalendar;

public class Abteilungsleiter extends Angestellter {

	public Abteilungsleiter(String nachname, String vorname, int id, float grundgehalt, GregorianCalendar geburtstag) {
		 super(nachname, vorname, id, grundgehalt, geburtstag);
		 this.gehaltsfaktor = 2;
	}

	public void promote(Angestellter a) {
		a.gehaltsfaktor *= 1.1f;
	}
}
