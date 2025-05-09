package L20.MauMau;

import java.util.*;

public class Skat implements Comparable<Skat> {
	public final char suit;
	public final String kind;

	public Skat(char suit, String kind) {
		this.suit = suit;
		this.kind = kind;
	}

	public static ArrayList<Skat> get_deck() {
		// Hearts, Spades, Clubs, Diamonds
		char[] suits = {'H', 'S', 'C', 'D'};
		// jack, Queen, King, Ace
		String[] kinds = {"7", "8", "9", "10", "J", "Q", "K", "A"};
		ArrayList<Skat> out = new ArrayList<>();
		out.ensureCapacity(suits.length * kinds.length);
		for (char suit: suits) {
			for (String kind: kinds) {
				out.add(new Skat(suit, kind));
			}
		}
		return out;
	}

	public static void main(String[] args) {
		ArrayList<Skat> deck = Skat.get_deck();
		ArrayList<Skat> hand = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.remove((int)(Math.random() * deck.size())));
		}
		print_hand(hand);
		System.out.println("---------");
		Collections.sort(hand);
		print_hand(hand);
	}

	private static void print_hand(ArrayList<Skat> hand) {
		for (Skat card : hand) {
			System.out.println(card);
		}
	}

	@Override
	public String toString() {
		return this.suit + ": " + this.kind;
	}

	// höhere wertigkeit bedeutet weiter links sprich -1
	public int compareTo(Skat o) {
		if (this.kind.equals("J") || o.kind.equals("J")) {
			return this.compareJack(o);
		}
		int suit = this.cmp(o.suit);
		if (suit != 0) {
			return suit;
		}
		return this.cmp(o.kind);
	}

	private int compareJack(Skat o) {
		int kind = this.cmp(o.kind);
		if (kind != 0) {
			return kind;
		}
		return this.cmp(o.suit);
	}

	// lucky that char is suit and String is kind
	private int cmp(char suit) {
		return get_weight(suit).compareTo(get_weight(this.suit));
	}

	private int cmp(String kind) {
		return get_weight(kind).compareTo(get_weight(this.kind));
	}

	private static Byte get_weight(char suit) {
		return switch (suit) {
			case 'C' -> 4;
			case 'S' -> 3;
			case 'H' -> 2;
			case 'D' -> 1;
			default -> 0;
		};
	}

	private static Byte get_weight(String kind) {
		try {
			return switch (kind) {
				case "J" -> 14;
				case "A" -> 13;
				case "10" -> 12;
				case "K" -> 11;
				case "Q" -> 10;
				default -> Byte.parseByte(kind);
			};
		} catch (NumberFormatException e) {
			// just ignore the Exception
			e.printStackTrace();
			return 0;
		}
	}
}
