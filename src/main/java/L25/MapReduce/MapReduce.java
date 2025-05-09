package L25.MapReduce;

import L25.ThrowingCon.ThrowingConsumer;
import org.jsoup.Jsoup;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class MapReduce {
	public static void main(String[] args) {
		List<String> urls = Arrays.asList(
				"https://en.wikipedia.org/wiki/Donald_Trump",
				"https://en.wikipedia.org/wiki/Angela_Merkel",
				"https://en.wikipedia.org/wiki/Vladimir_Putin"
		);
		try(
				BufferedWriter out = new BufferedWriter(new FileWriter("./src/main/java/L25/MapReduce/out"));
		) {
			// I have absolutely no idea what the Prof wanted us to do .-. shuffle?? would be interesting what the intended
			// solution would have been. But I think this works
			// We fetch in parallel the Wikiarticles Split the whole text into a Stream
			// collect the Streams into a Map, stream the resulting, merged Map again for sorting and writing
			urls.parallelStream()
					.map(ThrowingFunction.unchecked(url ->
							Jsoup.connect(url).get().text()
					))
					// ^ negates character class --> match anything NOT a-z or A-Z
					.flatMap(i -> Stream.of(i.split("[^a-zA-Z]+")))
					// collect is goated since it handles the joining of parallel streams automagically
					.collect(
							Collectors.groupingBy(
									i -> i,
									Collectors.summingInt(e -> 1)
							)
//							Collectors.toMap(
//									s -> s,
//									_ -> 1,
//									(c1, _) -> c1 + 1
//							)
					)
					.entrySet()
					.stream()
					.filter(e -> e.getValue() > 30)
					.sorted(Map.Entry.comparingByKey())
//					.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
//					.forEach(ThrowingConsumer.unchecked(e -> out.write(e.getKey() + " -> " + e.getValue() + "\n")));
					.forEach(e -> {
						try {
							out.write(e.getKey() + " -> " + e.getValue() + "\n");
						} catch (IOException ex) {
							throw new RuntimeException(ex);
						}
					})
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
