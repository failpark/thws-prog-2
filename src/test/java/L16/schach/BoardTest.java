package L16.schach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
	@Test
	public void BishopTest() {
		// Be4
		boolean[][] bishop_state = new boolean[][]{
				{false, true, false, false, false, false, false, true},
				{false, false, true, false, false, false, true, false},
				{false, false, false, true, false, true, false, false},
				{false, false, false, false, true, false, false, false},
				{false, false, false, true, false, true, false, false},
				{false, false, true, false, false, false, true, false},
				{false, true, false, false, false, false, false, true},
				{true, false, false, false, false, false, false, false}
		};
		LaeuferImpl l = new LaeuferImpl(4, 5);
		Brett brett = l.gibErlaubteFelder();
		// TODO: does assertArrayEquals(Object[], Object[]) use deepEquals internally?
		assertArrayEquals(bishop_state, brett.brett);

		// Ba1
		bishop_state = new boolean[][]{
				{true, false, false, false, false, false, false, false},
				{false, true, false, false, false, false, false, false},
				{false, false, true, false, false, false, false, false},
				{false, false, false, true, false, false, false, false},
				{false, false, false, false, true, false, false, false},
				{false, false, false, false, false, true, false, false},
				{false, false, false, false, false, false, true, false},
				{false, false, false, false, false, false, false, true}
		};
		l = new LaeuferImpl(1, 1);
		brett = l.gibErlaubteFelder();
		assertArrayEquals(bishop_state, brett.brett);
	}

	@Test
	public void RookTest() {
		// Re4
		boolean[][] rook_state = new boolean[][]{
				{false, false, false, false, true, false, false, false},
				{false, false, false, false, true, false, false, false},
				{false, false, false, false, true, false, false, false},
				{true, true, true, true, true, true, true, true},
				{false, false, false, false, true, false, false, false},
				{false, false, false, false, true, false, false, false},
				{false, false, false, false, true, false, false, false},
				{false, false, false, false, true, false, false, false}
		};
		TurmImpl t = new TurmImpl(4, 5);
		Brett brett = t.gibErlaubteFelder();
		assertArrayEquals(rook_state, brett.brett);

		// Ra1
		rook_state = new boolean[][]{
			{true, true, true, true, true, true, true, true},
			{true, false, false, false, false, false, false, false},
			{true, false, false, false, false, false, false, false},
			{true, false, false, false, false, false, false, false},
			{true, false, false, false, false, false, false, false},
			{true, false, false, false, false, false, false, false},
			{true, false, false, false, false, false, false, false},
			{true, false, false, false, false, false, false, false}
		};
		t = new TurmImpl(1, 1);
		brett = t.gibErlaubteFelder();
		assertArrayEquals(rook_state, brett.brett);
	}

	@Test
	public void MergeTest() {
		// Qa1
		boolean[][] test_state = new boolean[][]{
				{true, true, true, true, true, true, true, true},
				{true, true, false, false, false, false, false, false},
				{true, false, true, false, false, false, false, false},
				{true, false, false, true, false, false, false, false},
				{true, false, false, false, true, false, false, false},
				{true, false, false, false, false, true, false, false},
				{true, false, false, false, false, false, true, false},
				{true, false, false, false, false, false, false, true}
		};
		// Ra1
		boolean[][] rook_state = new boolean[][]{
				{true, true, true, true, true, true, true, true},
				{true, false, false, false, false, false, false, false},
				{true, false, false, false, false, false, false, false},
				{true, false, false, false, false, false, false, false},
				{true, false, false, false, false, false, false, false},
				{true, false, false, false, false, false, false, false},
				{true, false, false, false, false, false, false, false},
				{true, false, false, false, false, false, false, false}
		};
		// Ba1
		boolean[][] bishop_state = new boolean[][]{
				{true, false, false, false, false, false, false, false},
				{false, true, false, false, false, false, false, false},
				{false, false, true, false, false, false, false, false},
				{false, false, false, true, false, false, false, false},
				{false, false, false, false, true, false, false, false},
				{false, false, false, false, false, true, false, false},
				{false, false, false, false, false, false, true, false},
				{false, false, false, false, false, false, false, true}
		};
		Brett a = new Brett(rook_state);
		Brett b = new Brett(bishop_state);
		Brett test = a.merge(b);
		assertArrayEquals(test_state, test.brett);
	}

	@Test
	public void QueenTest() {
		// Qe4
		boolean[][] queen_state = new boolean[][]{
				{false, true, false, false, true, false, false, true},
				{false, false, true, false, true, false, true, false},
				{false, false, false, true, true, true, false, false},
				{true, true, true, true, true, true, true, true},
				{false, false, false, true, true, true, false, false},
				{false, false, true, false, true, false, true, false},
				{false, true, false, false, true, false, false, true},
				{true, false, false, false, true, false, false, false}
		};
		Dame q = new Dame(4, 5);
		Brett brett = q.gibErlaubteFelder();
		assertArrayEquals(queen_state, brett.brett);
		// Qa1
		queen_state = new boolean[][]{
				{true, true, true, true, true, true, true, true},
				{true, true, false, false, false, false, false, false},
				{true, false, true, false, false, false, false, false},
				{true, false, false, true, false, false, false, false},
				{true, false, false, false, true, false, false, false},
				{true, false, false, false, false, true, false, false},
				{true, false, false, false, false, false, true, false},
				{true, false, false, false, false, false, false, true}
		};
		q = new Dame(1, 1);
		brett = q.gibErlaubteFelder();
		assertArrayEquals(queen_state, brett.brett);
	}
}
