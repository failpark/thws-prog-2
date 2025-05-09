package L23.Bundesliga;

import java.util.*;

public class Mannschaft implements Comparable<Mannschaft> {
	String name;
	int anzahlGespielteSpiele;
	int tore;
	int gegentore;
	int punkte;

	public Mannschaft(String name, int anzahlGespielteSpiele, int tore, int gegentore, int punkte) {
		this.name = name;
		this.anzahlGespielteSpiele = anzahlGespielteSpiele;
		this.tore = tore;
		this.gegentore = gegentore;
		this.punkte = punkte;
	}

	@Override
	public String toString() {
		return String.format("%14s %3s %7s %3s", name, anzahlGespielteSpiele, tore + ":" + gegentore, punkte);
	}

	@Override
	public int compareTo(Mannschaft m) {
		if (this.punkte < m.punkte) return 1;
		else if (this.punkte > m.punkte) return -1;
		else {
			if (this.tore - this.gegentore < m.tore - m.gegentore) return 1;
			else if (this.tore - this.gegentore > m.tore - m.gegentore) return -1;
		}
		return this.name.compareTo(m.name);
	}

	public static List<Mannschaft> createTabelle() {
		List<Mannschaft> tabelle = new ArrayList<Mannschaft>(18);
		tabelle.add(new Mannschaft("Bay.München", 32, 75, 15, 82));
		tabelle.add(new Mannschaft("Bor.Dortmund", 32, 52, 36, 77));
		tabelle.add(new Mannschaft("B.Leverkusen", 32, 80, 31, 57));
		tabelle.add(new Mannschaft("B.M'gladbach", 32, 64, 49, 49));
		tabelle.add(new Mannschaft("Hertha BSC", 32, 41, 40, 49));
		tabelle.add(new Mannschaft("FC Schalke 04", 32, 46, 47, 48));
		tabelle.add(new Mannschaft("FSV Mainz 05", 32, 43, 41, 46));
		tabelle.add(new Mannschaft("1.FC Köln", 32, 36, 40, 41));
		tabelle.add(new Mannschaft("FC Ingolstadt", 32, 30, 37, 40));
		tabelle.add(new Mannschaft("VfL Wolfsburg", 32, 43, 48, 39));
		tabelle.add(new Mannschaft("Hamburger SV", 32, 37, 44, 38));
		tabelle.add(new Mannschaft("FC Augsburg", 32, 40, 48, 37));
		tabelle.add(new Mannschaft("Hoffenheim", 32, 38, 49, 37));
		tabelle.add(new Mannschaft("Darmstadt 98", 32, 36, 50, 35));
		tabelle.add(new Mannschaft("Werder Bremen", 32, 49, 65, 34));
		tabelle.add(new Mannschaft("VfB Stuttgart", 32, 48, 69, 33));
		tabelle.add(new Mannschaft("Ein.Frankfurt", 32, 33, 51, 33));
		tabelle.add(new Mannschaft("Hannover 96", 32, 29, 59, 22));

		Collections.sort(tabelle);
		return tabelle;
	}

	public static void main(String[] args) {
		List<Mannschaft> table = createTabelle();
		System.out.println("Exercise a:");
		table
				.stream()
				.filter(i -> i.punkte > 50)
				.forEach(System.out::println);
		System.out.println("Exercise b:");
		table.forEach(i -> System.out.println(i.name));
		System.out.println("Exercise c:");
		table
				.stream()
				.filter(i -> i.name.startsWith("F"))
				.sorted()
				.forEach(System.out::println);
		System.out.println("Exercise d:");
		System.out.println(table
				.stream()
				.max(Comparator.comparing(i -> i.gegentore))
				.orElseThrow()
		);
	}
}
