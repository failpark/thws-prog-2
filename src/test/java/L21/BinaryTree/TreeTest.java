package L21.BinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {
	@Test
	public void validTree_int() {
		Tree<Integer> tree = new Tree<>(0);
		tree.root.left = tree.get_node(1);
		tree.root.right = tree.get_node(2);
		tree.root.left.left = tree.get_node(3);
		String expected = "3\n1\n0\n2\n";
		assertEquals(expected, tree.toString());
	}

	@Test
	public void validTree_String() {
		Tree<String> tree = new Tree<>("Naomi");
		tree.root.left = tree.get_node("Anna");
		tree.root.right = tree.get_node("Raffi");
		tree.root.left.left = tree.get_node("Daniel");
		String expected = "Daniel\nAnna\nNaomi\nRaffi\n";
		assertEquals(expected, tree.toString());
	}

	@Test
	public void validTree_String_ex() {
		Tree<String> tree = new Tree<>("Cool");
		tree.root.left = tree.get_node("Aarson");
		tree.root.right = tree.get_node("Zylla");
		tree.root.right.left = tree.get_node("Garret");
		String expected = "Aarson\nCool\nGarret\nZylla\n";
		assertEquals(expected, tree.toString());
	}
}
