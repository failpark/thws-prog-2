package L16.inheritance;

import java.util.ArrayList;

public class StackAttr implements Stack {
	private ArrayList stack = new ArrayList();

	public void push(Object e) {
		this.stack.add(e);
	}

	public Object pop() {
		return this.stack.remove(this.stack.size() - 1);
	}
}
