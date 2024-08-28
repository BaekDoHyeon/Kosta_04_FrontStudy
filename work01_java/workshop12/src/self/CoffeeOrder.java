package self;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CoffeeOrder {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Cappuccino");
		list.add("Americano");
		list.add("Espresso");
		list.add("Caramel Macchiato");
		list.add("Mocha");
		list.add("Cappuccino");
		list.add("Espresso");
		list.add("Latte");
		
		Stream<String> stream = list.stream();
		stream.filter(i -> i.substring(i.length()-1).equals("o"))
			.sorted()
			.distinct()
			.forEach(i -> System.out.println(i));	
		
	}
}
