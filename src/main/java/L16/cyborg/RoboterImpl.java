package L16.cyborg;

public class RoboterImpl implements Roboter {
	public void aufladen() {
	}

	public void warten() {
	}

	public void arbeiten() {
	}

	public static Reaktion reaction(Gefahr g) {
		return Autofahren.default_reaction(g);
	}

	public Reaktion entscheide(Gefahr g) {
		return reaction(g);
	}

	// I'd love to have a way to require every Implementor of Autofahren
	// to have to Override toString or even better to just provide a name
	// and don't be able to override toString ... doesn't seem possible
	// with an Interface... I've seen some tricks with abstract classes
	// but since we are REQUIRED to use an interface I'cant do this it seems
	@Override
	public String toString() {
		return "Roboter";
	}
}
