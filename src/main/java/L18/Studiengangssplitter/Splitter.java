package L18.Studiengangssplitter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Splitter {
	// is fine to be static since I don't want to init this class
	private static final mnum[] progs = {
			new mnum("WInf", 5000000, 5099999),
			new mnum("Inf", 5100000, 5199999),
			new mnum("EC", 6100000, 6199999)
	};

	public static void main(String[] main) {
		File in = prompt_user();
		sort_into(read_m_nums(in), progs);
		write_all(progs);

		// Solution for Worksheet
//		File in1 = prompt_user();
//		splitStudiengaenge(in1.getPath());
	}

	private static File prompt_user() {
		Scanner scanner = new Scanner(System.in);
		File file;
		while(true) {
			System.out.println("Gib einen Pfad zu einer Datei");
			String path = scanner.nextLine();
			if (path.isEmpty()) System.exit(0);
			file = new File(path);
			if (file.exists() && file.isFile()) {
				scanner.close();
				return file;
			}
			System.err.println("Datei ist ungültig");
		}
	}

	private static void sort_into(ArrayList<Integer> in, mnum[] progs) {
		boolean was_valid;
		for (Integer num: in) {
			was_valid = false;
			for (mnum prog : progs) {
				if (prog.is_valid(num)) {
					was_valid = true;
					prog.add(num);
					break;
				}
			}
			if (!was_valid) {
				throw new MatrikelNummerException("Encountered invalid num");
			}
		}
	}

	private static void write_all(mnum[] progs) {
		for(mnum prog: progs) {
			prog.write();
		}
	}

	private static void splitStudiengaenge(String path) {
		File in = new File(path);
		try {
			sort_into(read_m_nums(in), progs);
			write_all(progs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<Integer> read_m_nums(File file) {
		ArrayList<Integer> nums = new ArrayList<>();
		try (BufferedReader buff_read = new BufferedReader(new FileReader(file))) {
			do {
				String line = buff_read.readLine();
				if (line == null) return nums;
				nums.add(Integer.parseInt(line));
			}
			while(true);
		} catch (IOException e) {
			throw new MatrikelNummerException("Could not read file");
		} catch (NumberFormatException e) {
			throw new MatrikelNummerException("Encountered invalid num");
		}
	}
}
