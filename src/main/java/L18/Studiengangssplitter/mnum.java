package L18.Studiengangssplitter;

import java.io.*;
import java.util.ArrayList;

public class mnum {
	public final String study_program;
	public final int start;
	public final int end;
	private ArrayList<Integer> nums = new ArrayList();

	public mnum(String study_program, int start, int end) {
		this.study_program = study_program;
		this.start = start;
		this.end = end;
	}

	public boolean is_valid(int num) {
		return this.start <= num && num <= this.end;
	}

	public void add(Integer num) {
		nums.add(num);
	}

	public void write() {
		String path = "./target/Splitter/" + this.study_program + "Nr.txt";
		try (
				BufferedWriter fos = new BufferedWriter(new FileWriter(path));
				) {
			for (Integer num: this.nums) {
				fos.write(num.toString());
				fos.newLine();
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not write to path: " + path);
		}
	}
}
