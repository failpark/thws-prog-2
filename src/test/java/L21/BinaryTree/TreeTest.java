package L21.BinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {
	@Test
	public void validTree_int() {
		Tree<Integer> tree = new Tree<>(new Node<>(0));
		tree.root.left = new Node<>(1);
		tree.root.right = new Node<>(2);
		tree.root.left.left = new Node<>(3);
		String expected = "3\n1\n0\n2\n";
		assertEquals(expected, tree.toString());
	}

	@Test
	public void validTree_String() {
		Tree<String> tree = new Tree<>(new Node<>("Naomi"));
		tree.root.left = new Node<>("Anna");
		tree.root.right = new Node<>("Raffi");
		tree.root.left.left = new Node<>("Daniel");
		String expected = "Daniel\nAnna\nNaomi\nRaffi\n";
		assertEquals(expected, tree.toString());
	}
}
