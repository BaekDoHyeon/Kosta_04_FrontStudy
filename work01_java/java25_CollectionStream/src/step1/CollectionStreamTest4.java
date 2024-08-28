package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 *  스트림 만드는 작업과정
 *  1. 스트림 생성.. stream()
 *  2. 중간 연산자
 *  3. 최종 연산자
 */
public class CollectionStreamTest4 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		// =============== 1. 스트림은 일회성이다. ===============
		Stream<Integer> intStream = list.stream();
		intStream.forEach(System.out::println);
		
		System.out.println();
		
		intStream = list.stream(); //추가.. 다시 스트림을 연다.
		intStream.forEach(System.out::println);
		
		System.out.println("-------------------------");

		// Stream<T>
		Stream<Integer> intStream2 = Stream.of(1, 2, 3, 4, 5); //스트림 생성...count
		System.out.println("intStream2 count: " + intStream2.count());
		//System.out.println("intStream2 sum: " + intStream2.sum()); sum 기능은 없다. -> IntStream 에는 존재한다.
		
		
		System.out.println("-------------------------");
		// IntStream
		int[] intArr = {1, 2, 3, 4, 5};
		IntStream intStream3 = Arrays.stream(intArr);
		//intStream3.forEach(System.out::println);
		//System.out.println("intStream3 sum: " + intStream3.sum());
		//System.out.println("intStream3 average: " + intStream3.average());
		System.out.println("intStream3 findFirst: " + intStream3.findFirst());
	}
	
}
