package L24.Cards;

import java.util.*;
import java.util.stream.*;

public class Kartendeck {
	List<Karte> karten;
	public void erzeugeDeck() {
		this.karten = Stream.of(Farbe.values())
				.flatMap(farbe -> Stream.of(Wert.values())
						.map(wert -> new Karte(farbe, wert))
				).collect(Collectors.toList());
	}
	public static void main(String[] args) {
		Kartendeck deck = new Kartendeck();
		deck.erzeugeDeck();
		System.out.println(deck);
	}

	public String toString() {
		if (this.karten == null || this.karten.isEmpty()) return "";
		return this.karten
				.stream()
				.map(Karte::toString)
				.reduce("", (acc, curr) -> acc.isEmpty() ? curr : acc + ", " + curr);
	}
}