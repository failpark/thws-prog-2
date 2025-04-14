package L16.cyborg;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Autofahren robot = new RoboterImpl();
		Autofahren human = new MenschImpl();
		Autofahren cyborg = new Cyborg();
		Autofahren[] arr = {robot, human, cyborg};
		Gefahr[] dangers = Gefahr.values();
		for (Autofahren a: arr) {
			list_out(
					a.toString(),
					test(a, dangers),
					dangers
			);
		}
	}


	public static ArrayList<Reaktion> test(Autofahren a, Gefahr[] dangers) {
		ArrayList<Reaktion> out = new ArrayList<>();
		for (Gefahr g: dangers) {
			out.add(a.entscheide(g));
		}
		return out;
	}

	public static void list_out(String class_name, ArrayList<Reaktion> reactions, Gefahr[] dangers) {
		for (int i = 0; i < dangers.length; i++) {
			System.out.println(Autofahren.formatted_out(reactions.get(i), dangers[i], class_name));
		}
	}
}
