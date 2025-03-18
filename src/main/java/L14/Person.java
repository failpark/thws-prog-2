package L14;

public class Person {
	String vorname;
	String nachname;
	Adresse adresse;

	public static void validate(String check) {
		char c = check.charAt(0);
		if (c < 'A' || c > 'Z') {
			throw new RuntimeException("Property should be capitalized");
		}
	}

	public static void validate_hausnummer(String check) {
		char c = check.charAt(0);
		if (c < '0' || '9' < c) {
			throw new RuntimeException("Hausnummer muss mit Ziffer beginnen");
		}
	}

	public Person(String vorname, String nachname, String strasse, String hausnummer,  int plz, String ort) {
		validate(vorname);
		validate(strasse);
		validate(ort);
		validate_hausnummer(hausnummer);
		Adresse a = new Adresse(strasse, hausnummer, plz, ort);
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = a;
	}
}
