package L21.BinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {
	@Test
	public void validTree_int() {
		Tree<Integer> tree = new Tree<>(0);
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		String expected = "3\n2\n1\n0\n";
		assertEquals(expected, tree.toString());
	}

	@Test
	public void validTree_String() {
		Tree<String> tree = new Tree<>("Naomi");
		tree.insert("Anna");
		tree.insert("Raffi");
		tree.insert("Daniel");
		String expected = "Raffi\nNaomi\nDaniel\nAnna\n";
		assertEquals(expected, tree.toString());
	}

	@Test
	public void validTree_String_ex() {
		Tree<String> tree = new Tree<>("Cool");
		tree.insert("Aarson");
		tree.insert("Zylla");
		tree.insert("Garret");
		String expected = "Zylla\nGarret\nCool\nAarson\n";
		assertEquals(expected, tree.toString());
	}
}
