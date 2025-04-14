package L17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Exceptions {
	public static void main(String[] args) throws FileNotFoundException {
//		throwNumberFormat();
//		throwIndexOutOfBounds();
//		throwNullPointer();
//		throwOutOfMemory();
//		throwFileNotFound();
		throwArithmetic();
	}
	public static void throwNumberFormat() {
		Integer.valueOf("exception");
	}

	public static void throwIndexOutOfBounds() {
		int i = new int[]{1, 2}[3];
	}

	public static void throwNullPointer() {
		Array.getLength(null);
	}

	public static void throwOutOfMemory() {
		List<byte[]> list = new ArrayList<>();
		while (true) {
			byte[] b = new byte[1048576];
			list.add(b);
		}
	}

	public static void throwFileNotFound() throws FileNotFoundException {
		File file = new File("./nonexistent.txt");
		FileInputStream fis = new FileInputStream(file);
	}

	public static void throwArithmetic() {
		int i = 1 / 0;
	}
}
