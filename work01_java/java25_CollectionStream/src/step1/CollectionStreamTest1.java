package step1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionStreamTest1 {

	public static void main(String[] args) {
		// 1.문자열 리스트가 소스인 스트림을 생성
		List<String> friuts = new ArrayList<>();
		friuts.add("Apple");
		friuts.add("Banana");
		friuts.add("Apple");
		friuts.add("Melon");
		friuts.add("Grape");
		friuts.add("Orange");
		friuts.add("Melon");
		friuts.add("Grape");
		friuts.add("Apple");
		
		Stream<String> streamList = friuts.stream(); // 1) 스트림 생성
//		stream.distinct().limit(3).sorted().forEach(i -> System.out.println(i + " "));
		List<String> list = streamList.distinct().limit(3).sorted().collect(Collectors.toList());
		System.out.println(list);
		
		
		System.out.println("\n============================================");
		Set<String> set = new HashSet<>();
		set.add("이희주");
		set.add("김믿음");
		set.add("이찬영");
		
		Stream<String> streamSet = set.stream();
		streamSet.forEach(s -> System.out.print(s + " "));
		
		
		System.out.println("\n============================================");
		Map<Integer, String> map = new HashMap<>();
		map.put(111, "이희주");
		map.put(222, "김믿음");
		map.put(333, "이찬영");
		
		map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
	
	}
}
