package L15;

import java.util.Vector;

public class Abteilung {
	public String name;
	public Abteilungsleiter leiter;
	public Vector<Angestellter> angestellte;

	public Abteilung(String name, Abteilungsleiter leiter, Vector<Angestellter> angestellte) {
		this.name = name;
		this.leiter = leiter;
		this.angestellte = angestellte;
	}
}
