package step1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTest4 {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(100, 45, 200, 33, 44, 3, 1, 99);
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, (a, b) -> b - a);
		System.out.println(list);
		
	}
}
