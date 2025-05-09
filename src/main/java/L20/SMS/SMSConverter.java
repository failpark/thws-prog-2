package L20.SMS;

import java.io.*;
import java.util.*;

public class SMSConverter {
	private final static Map<Character, Byte> MAP = get_map();

	public static void main(String[] args) {
		try (
			BufferedReader in = new BufferedReader(new FileReader("./src/main/java/L20/SMS/Zeichenkontakte.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("./src/main/java/L20/SMS/Nummernkontakte.txt"));
		) {
			while (true) {
				String line = in.readLine();
				if (line == null) break;
				try {
					out.write(convert(line));
				} catch (IllegalTelephoneNumberException e) {
					e.printStackTrace();
				}
				out.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Map<Character, Byte> get_map() {
		Map<Character, Byte> map = new HashMap<>();
		byte idx = 2;
		byte count = 0;
		for (char c = 'A'; c <= 'Z'; c++) {
			if (count > 2) {
				idx++;
				count = 0;
			}
			map.put(c, idx);
			if (c == 'R' || c == 'Y') {
				continue;
			}
			count++;
		}
		return map;
	}

	static String convert(String in) throws IllegalTelephoneNumberException {
		String out = "";
		for (int i = 0; i < in.length(); i++) {
			try {
				Byte b = MAP.get(in.charAt(i));
				if (b == null) throw new IllegalTelephoneNumberException("Invalid Char. Only A-Z is allowed");
				out += String.valueOf(b);
			} catch (Exception e) {
				throw new IllegalTelephoneNumberException("Invalid Char. Only A-Z is allowed");
			}
		}
		return out;
	}
}

