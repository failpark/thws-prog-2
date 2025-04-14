package L16.cyborg;

public class Cyborg implements Mensch, Roboter {
	public void essen() {

	}

	public void schlafen() {

	}

	public void aufladen() {

	}

	public void warten() {

	}

	public void arbeiten() {

	}

	private static boolean rand() {
		return Math.random() > 0.5;
	}

	@Override
	public String toString() {
		return "Cyborg";
	}

	public Reaktion entscheide(Gefahr g) {
		Reaktion robot = RoboterImpl.reaction(g);
		Reaktion human = MenschImpl.reaction(g);
		if (robot == human || rand()) {
			return robot;
		}
		return human;
	}
}
