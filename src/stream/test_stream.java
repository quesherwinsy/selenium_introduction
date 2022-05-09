package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test_stream {
	// @Test
	public void regular() {
		// count list of names with letter A.
		ArrayList<String> namez = new ArrayList<String>();
		namez.add("ahjeet");
		namez.add("don");
		namez.add("alek");
		namez.add("adan");
		namez.add("ron");
		int count = 0;

		for (int i = 0; i < namez.size(); i++) {
			String actual = namez.get(i);
			if (actual.startsWith("a")) {
				count++;
			}
		}

		System.out.println(count);
	}

	// @Test
	public void streamFilter() {
		// count list of names with letter A with java stream
		ArrayList<String> namez = new ArrayList<String>();
		namez.add("ahjeet");
		namez.add("don");
		namez.add("alekhya");
		namez.add("adan");
		namez.add("ran");
		// intermediate operation will not work if there is no terminal operation
		// terminal operation will execute if intermediate operation is true
		// stream package creation
		// how to use stream filter (terminal operation)
		long count = namez.stream().filter(s -> s.startsWith("a")).count();
		System.out.println(count);

		long d = Stream.of("Ahjeet", "don", "Alek", "Adon", "ron").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		// print all names from arraylist via streams
		// namez.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		namez.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

	// @Test
	public void streamMap() {
		// print names with last letter A and uppercase via streams and map
		Stream.of("Ahjeet", "don", "Alekhya", "Adon", "Rona").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		System.out.println("");

		// print names with first letter A and uppercase and sorted
		List<String> namez = Arrays.asList("Ashit", "doon", "Abekya", "Udon", "Roam");
		namez.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		System.out.println("");

		// merge 2 arraylist via streams
		List<String> namez2 = Arrays.asList("Asshle", "Boon", "Abex", "Nood", "Room");
		Stream<String> newStream = Stream.concat(namez.stream(), namez2.stream());
		// newStream.sorted().forEach(s->System.out.println(s));
		boolean checkname = newStream.anyMatch(s -> s.equalsIgnoreCase("Ashit"));
		System.out.println(checkname);
		Assert.assertTrue(checkname);
	}

	@Test
	public void streamCollect() {
		// collect all result of test and print
		List<String> ls = Stream.of("Ahjeet", "don", "Alekhya", "Adon", "Rona").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));

		// print unique number, sort, display 3rd value
		List<Integer> num1 = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		// get value unique/distinct, sort, list into collection
		List<Integer> li = num1.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}
}
