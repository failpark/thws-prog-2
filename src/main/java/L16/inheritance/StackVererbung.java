package L16.inheritance;

import java.util.ArrayList;

// Nachteile Vererbung: Zugriff auf alle öffentlichen Methoden von ArrayList
// Wollen wahrscheinlich nur begrenzt Schnittstellen teilen.
public class StackVererbung extends ArrayList implements Stack {
	public void push(Object e) {
		this.add(e);
	}

	public Object pop() {
		return this.remove(this.size() - 1);
	}
}
