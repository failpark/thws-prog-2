package L16.inheritance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
	public void test_stack(Stack s) {
		s.push(1);
		s.push(4);
		assertEquals(4, s.pop());
		assertEquals(1, s.pop());
	}

	@Test
	public void test_inheritance() {
		Stack s = new StackVererbung();
		test_stack(s);
	}

	@Test
	public void test_attr() {
		Stack s = new StackAttr();
		test_stack(s);
	}
}
