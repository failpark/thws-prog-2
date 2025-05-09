package L20;

import java.util.*;

public class MultiMap<Key, Value> {
	private Map<Key, List<Value>> map = new HashMap<>();

	public void put(Key key, Value value) {
		map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
	}

	public List<Value> get(Key key) {
		return map.getOrDefault(key, Collections.emptyList());
	}

	// Testing the implementation
	public static void main(String[] args) {
		MultiMap<String, String> dict = new MultiMap<>();

		dict.put("to clean", "reinigen");
		dict.put("to clean", "säubern");
		dict.put("to clean", "putzen");

		dict.put("to expand", "vergrößern");
		dict.put("to expand", "wachsen");

		System.out.println(dict.get("to clean"));  // [reinigen, säubern, putzen]
		System.out.println(dict.get("to expand")); // [vergrößern, wachsen]
	}
}