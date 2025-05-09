package L22.Sort;

import java.util.*;

public class Kreuzwortraetsel {
	static String[] alleWoerter = {"Bienenschwarm", "Buch", "Bibel", "Beige", "Barriere", "Bein", "Beil", "Christ", "Christian", "Carmen"};

	public static void main(String[] args) {
		impl_comp();
		anon_class();
	}

	private static void impl_comp() {
		TreeSet<String> t = new TreeSet<>(new Comp());
		t.addAll(Arrays.asList(alleWoerter));
		for(String wort : t) {
			System.out.println(wort);
		}
	}

	/*
	* Pro:
	* - no separate class file needed
	* - impl code is close to point of use
	* - good for one-off
	* Con:
	* - not reusable
	* - harder to read (especially if its more complex)
	* - isolated testing is harder
	* - can be harder to understand
	* */

	private static void anon_class() {
		TreeSet<String> t = new TreeSet<>(new Comparator<String>() {
			public int compare(String s1, String s2) {return Comp.comp(s1, s2);}
		});
		t.addAll(Arrays.asList(alleWoerter));
		for(String wort : t) {
			System.out.println(wort);
		}
	}
}
