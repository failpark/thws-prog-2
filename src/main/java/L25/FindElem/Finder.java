package L25.FindElem;

import java.io.*;
import java.util.function.*;

public class Finder {
	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new FileReader("./src/main/java/L25/FindElem/in.csv"))) {
			Predicate<String> finder = i -> {
				String[] arr = i.split(";");
				return arr[arr.length - 1].contains("x");
			};
			System.out.println("a)");
			System.out.println(in.lines()
					.filter(finder)
					.findAny()
					.orElseThrow());
			System.out.println("b)");
			System.out.println(in.lines()
					.anyMatch(finder)
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
