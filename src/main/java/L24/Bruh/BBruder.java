package L24.Bruh;

import java.util.*;
import java.util.stream.Collectors;

public class BBruder {
	String name;
	int bankDrueckenGewicht;
	int knieBeugenGewicht;

	public BBruder(String name, int bankDrueckenGewicht, int
			knieBeugenGewicht) {
		this.name = name;
		this.bankDrueckenGewicht = bankDrueckenGewicht;
		this.knieBeugenGewicht = knieBeugenGewicht;
	}

	@Override
	public String toString() {
		return String.format(
				"Name: %s, Bankdrücken: %dkg, Kniebeugen %dkg",
				name, bankDrueckenGewicht, knieBeugenGewicht);
	}

	public static void main(String[] args) {
		List<BBruder> bBrothers = List.of(new BBruder("Burt", 238, 311),
				new BBruder("Bronski", 200, 274),
				new BBruder("Bruno", 236, 328));

		System.out.println("a)");
		System.out.println(bBrothers
				.stream()
				.map(b -> b.name)
				.reduce("", (acc, name) -> acc.isEmpty() ? name : acc + ", " + name)
		);
		System.out.println("b)");
		System.out.println(bBrothers
				.stream()
				.map(b -> b.bankDrueckenGewicht)
				.reduce(0, Integer::sum)
				/ (double) bBrothers.size()
		);
		System.out.println("d)");
		System.out.println(bBrothers.stream().map(b -> b.name).collect(Collectors.joining(", ")));
		System.out.println("e)");
		System.out.println(bBrothers.stream().mapToDouble(b -> b.bankDrueckenGewicht).average().orElse(0.0));
	}
}