package L21.BinaryTree;

public class Tree<T> {
	public static class Node<T> {
		private T inner;
		public Node<T> left;
		public Node<T> right;

		public Node(T inner) {
			this.inner = inner;
		}

		public T get_inner() {
			return this.inner;
		}
	}

	Node<T> root;

	public Tree(T root) {
		this.root = new Node<>(root);
	}

	public Node<T> get_node(T t) {
		return new Node<>(t);
	}

	public void print() {
		System.out.println(get_structure());
	}

	@Override
	public String toString() {
		return this.get_structure();
	}

	String get_structure() {
		if (this.root == null) return "";
		return get_structure(this.root);
	}

	public String get_structure(Node<T> node) {
		String out = "";
		if (node.left != null) out += get_structure(node.left);
		out += node.get_inner();
		out += '\n';
		if (node.right != null) out += get_structure(node.right);
		return out;
	}
}