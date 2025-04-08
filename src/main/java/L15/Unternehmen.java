package L15;

import java.util.Vector;

public class Unternehmen {
	public String name;
	public Vector<Abteilung> abteilungen;

	public Unternehmen(String name, Vector<Abteilung> abteilungen) {
		this.name = name;
		this.abteilungen = abteilungen;
	}
}
