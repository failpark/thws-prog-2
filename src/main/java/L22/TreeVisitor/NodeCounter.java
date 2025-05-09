package L22.TreeVisitor;

public class NodeCounter<T> implements Visitor<T> {
	private int count = 0;
	public void visit(Baum.Knoten<T> curr) {
		this.count++;
	}
	public int get_count() {
		return this.count;
	}
}
