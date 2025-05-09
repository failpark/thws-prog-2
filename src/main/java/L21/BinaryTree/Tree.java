package L21.BinaryTree;

public class Tree<T> {
	Node<T> root;

	public Tree(Node<T> root) {
		this.root = root;
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