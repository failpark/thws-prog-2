package L19.GenericStack;

import java.util.ArrayList;

public class GenericStack<T> extends ArrayList<T> implements Stack<T> {
	public void push(T e) {
		this.add(e);
	}

	public T pop() {
		return this.remove(this.size() - 1);
	}
	public static void main(String[] args) {
		GenericStack<String> s = new GenericStack<>();
		s.push("Hallo");
		s.push("Welt");
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
