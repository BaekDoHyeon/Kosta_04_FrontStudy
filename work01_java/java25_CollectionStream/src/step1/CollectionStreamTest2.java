package step1;
/*
 *  스트림의 특징
 *  1. Read Only - 스트림은 데이터소스로부터 데이터를 읽어들이기만 할 뿐 변경하지 않는다.
 *  2. 일회용이다. - Iterator 처럼 일회용이다. 최종연산이 진행되면 닫힌다.(필요하면 다시 생성해서 사용해야 한다.)
 *  3. 최종연산 전까지 스트림의 중간연산이 수행되지 않는다. - 지연된 연산
 *  4. 병령처리 작업이 가능하다. - 멀티 쓰레드 지원
 *     FP(함수형 언어)는 빅데이터(대용량 작업)를 빠르게 처리하기 위해서 발전되어온 기술이다. AI
 *     그러기 위해서는 직렬적 작업보다는 병렬 작업으로 많은 양의 데이터 효율적으로 처리하는 기술이 필수이다.
 *  5. Stream<T>        VS      IntStream
 *     Stream<Double>		    DoubleStream
 *     Stream<Long>			    LongStream
 *     Stream<Box>              FloatStream                           
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionStreamTest2 {

	public static void main(String[] args) {
		// 1.문자열 리스트가 소스인 스트림을 생성
		List<String> fruits = new ArrayList<>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Melon");
		fruits.add("Grape");
		fruits.add("Orange");
		fruits.add("Melon");
		fruits.add("Grape");
		fruits.add("Apple");
		
		System.out.println("원본 리스트1 ::: " + fruits);
		Stream<String> stream = fruits.stream(); // 1) 스트림 생성
		stream.distinct().limit(3).sorted().forEach(i -> System.out.println(i + " "));
		System.out.println("원본 리스트2 ::: " + fruits);
		
		//2. 문자열 배열이 소스인 스트림
		String[] strArr = { "dd", "aaa", "CC", "cc", "b" };
		Stream<String> streamStr = Stream.of(strArr);
		streamStr.forEach(System.out::println); //여기서 이미 최종연산 진행됐다. (스트림요소를 꺼냈다.)
		
		//long count = streamStr.count();
		//System.out.println("남은 데이터 갯수: " + count); //스트림이 닫혔다. 다시 사용할 수 없다.
		
		//3. 1 ~ 45 까지의 값을 무한반복 출력
		IntStream intStream = new Random().ints(1, 46);
		//intStream.forEach(i -> System.out.println(i + " "));
		intStream.distinct().limit(6).sorted().forEach(i -> System.out.print(i + " "));
		
		//4.
		String[] strArr2 = { "dd", "aaa", "CC", "cc", "b" };
		Stream<String> strStream = Stream.of(strArr);
		
		//int sum = strStream.mapToInt(s -> s.length()).sum();
		//System.out.println("\n모든 문자열의 길이의 합: " + sum);
		
		//해당 작업을 병렬처리로 만들 수 있다.
		int sum = strStream.parallel().mapToInt(s -> s.length()).sum();
		System.out.println("\n모든 문자열의 길이의 합: " + sum);
	}
}
