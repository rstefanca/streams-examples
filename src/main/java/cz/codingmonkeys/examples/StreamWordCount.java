package cz.codingmonkeys.examples;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * @author rstefanca
 */
public class StreamWordCount {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get("test.txt");
		String words =
				Files.lines(path)
						.flatMap(line -> Arrays.stream(line.split("\\b")))
						.filter(s -> !" ".equals(s))
						.collect(groupingBy(w -> w, counting()))
						.entrySet().stream()
						.sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed())
						.limit(20)
						.map(Map.Entry::getKey)
						.collect(joining(","));

		System.out.println(words);

	}
}
