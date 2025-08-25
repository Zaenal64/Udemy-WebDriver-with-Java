package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

//@Test
public class javaSterams {

	// Count the number of names starting with alphabet A in list

	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("aon");
		names.add("Test");
		names.add("Add");
		names.add("Accept");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A") || actual.startsWith("a")) {
				count++;
			}
		}
		System.out.println(count);
	}

//	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("aon");
		names.add("Test");
		names.add("Add");
		names.add("Accept");
		// there is no life for intermediate operator if there is no terminal operator
		// terminal operation will exceute only if inter operator (filter) returns true
		// we can create stream
		// how to use filter in stream API
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		Long d = Stream.of("Abhijeet", "aon", "Test", "Add", "Accept").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		//Print all the names of ArrayList
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		
	}
	
	//@Test
	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("man");
		names.add("Don");
		names.add("Women");

		//print names which have last letter as "a" with Uppercase
		Stream.of("Abhijeet", "aon", "Test", "Add", "Accept").filter(s->s.endsWith("t")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		//print names which have first letter as a with uppercase and sorted
		
		List<String>names1=Arrays.asList("Abhijeet", "aon", "Test", "Add", "Accept");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Merging 2 different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Asept")); //Accept  
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Abhijeet", "aon", "Test", "Add", "Accept").filter(s->s.endsWith("t")).map(s->s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer>values = Arrays.asList(3,2,7,5,1,2,9,7);
		//print unique number from this array
		//sort the array - 3rd index ->1,2,3,5,7,9
		values.stream().distinct().forEach(s->System.out.println(s)); //Print all values
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(3));
		
	}

}
