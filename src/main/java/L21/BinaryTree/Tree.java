package L21.BinaryTree;

public class Tree<T extends Comparable<T>> {
	public static class Node<T extends Comparable<T>> {
		private final T inner;
		public Node<T> left;
		public Node<T> right;

		public Node(T inner) {
			this.inner = inner;
		}

		public T get_inner() {
			return this.inner;
		}

		public int compareTo(Node<T> o) {
			return this.inner.compareTo(o.inner);
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

	public void insert(T n) {
		if (this.root == null) {
			this.root = new Node<>(n);
			return;
		}
		insert(this.root, new Node<>(n));
	}

	private void insert(Node<T> tmp, Node<T> n) {
		if (tmp.compareTo(n) < 0) {
			if (tmp.left == null) tmp.left = n;
			else insert(tmp.left, n);
		} else {
			if (tmp.right == null) tmp.right = n;
			else insert(tmp.right, n);
		}
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