package L21.BinaryTree;

public class Node<T> {
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
