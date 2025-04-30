package L17;

import java.io.*;
import java.util.Scanner;
import java.util.function.Consumer;

public class BufferedStream {

	public static void copyUnbuffered(String path) {
		try (FileInputStream fis = new FileInputStream(path);
			 FileOutputStream fos = new FileOutputStream("target/unbufferedOutput");
		) {
			int content;
			while ((content = fis.read()) != -1) {
				fos.write(content);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void copyBuffered(String path) {
		try (FileInputStream fis = new FileInputStream(path);
			 BufferedInputStream bis = new BufferedInputStream(fis);
			 FileOutputStream fos = new FileOutputStream("target/bufferedOutput");
			 BufferedOutputStream bos = new BufferedOutputStream(fos);
		) {
			int content;
			do {
				content = bis.read();
				bos.write(content);
			} while (content != -1);

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void copyUnbufferedArray(String path) {
		try (FileInputStream fis = new FileInputStream(path);
			 FileOutputStream fos = new FileOutputStream("target/unbufferedArrayOutput");
		) {
			byte[] contents;
			while ((contents = fis.readNBytes(1024)).length > 0) {
				fos.write(contents);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static long run(Consumer<String> f, String path) {
		long start;
		long end;
		long diff = 0;
		int n = 10;
		for (int i = 0; i < n; i++) {
			start = System.currentTimeMillis();
			f.accept(path);
			end = System.currentTimeMillis();
			diff += end - start;
		}
		return diff / n;
	}

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Path:");
//		String path = scanner.nextLine();
//		scanner.close();
		String path = "./target/test.mp3";

		long diff1 = run(BufferedStream::copyUnbuffered, path);
		long diff2 = run(BufferedStream::copyBuffered, path);
		long diff3 = run(BufferedStream::copyUnbufferedArray, path);

		System.out.println("Unbuffered:\t\t\t" + diff1 + "ms");
		System.out.println("Buffered:\t\t\t" + diff2 + "ms");
		System.out.println("Unbuffered Array:\t" + diff3 + "ms");
		System.out.println();
		System.out.println("Unbuffered Array (base)");
		System.out.println("Buffered:\t" + diff2/diff3 + " times slower");
		System.out.println("Unbuffered:\t" + diff1/diff3+ " times slower");
	}
}