package step2;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

//중간처리 연산자...
public class Stream02ProcessMethod {

	public static void main(String[] args) {
		System.out.println("========= 1. 중간처리 연산자 잘못사용하는 경우 =========");
		int[] intArr = {1, 2, 3, 4, 5};
		Arrays.stream(intArr)
				.filter(i -> i % 2 == 0)
				.peek(System.out::print); //최종 처리가 없으면 출력이 되질 않는다. (중간연산자는 지연된 연산을 한다.)
		
		
		System.out.println("\n========= 2. 중간처리 연산자 peek()을 제대로 이용 =========");
		long sum = Arrays.stream(intArr)
						//.filter(i -> i % 2 == 0)
						.peek(i -> System.out.print(i + " "))
						.count();  //최종 처리
		
		
		System.out.println("\n====================================================");
		OptionalInt sum2= Arrays.stream(intArr)
				//.filter(i -> i % 2 == 0)
				.peek(i -> System.out.print(i + "^^ "))
				.findFirst();  //최종 처리
		
		System.out.println("\nResult " + sum);
	}

}
