package L22.TreeVisitor;

public interface Visitor<T> {
	public void visit(Baum.Knoten<T> curr);
}
