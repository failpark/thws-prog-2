package L22.Sort;

import java.util.*;

public class Comp implements Comparator<String> {
	public static int comp(String s1, String s2) {
		int len_comp = Integer.compare(s1.length(), s2.length());
		return len_comp != 0 ? len_comp : s1.compareTo(s2);
	}
	public int compare(String s1, String s2) {
		return comp(s1, s2);
	}
}
