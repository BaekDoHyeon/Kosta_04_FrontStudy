package step1;

import java.util.Arrays;
import java.util.List;

//병렬처리 작업 코드로 확인
public class CollectionStreamTest3 {

	public static void main(String[] args) {
		//직렬처리... main 쓰레드 혼자 작업...
		/*
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		//시각을 측정하기 위해 사용,,,
		long start = System.currentTimeMillis();
		
		numbers.forEach(number -> {
			try {
				Thread.sleep(1000);
				System.out.println(number + ": " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				System.out.println("중지되었습니다..");
			}	
		});
		
		long duration = (System.currentTimeMillis() - start);
		double seconds = duration / 1000.0;
		System.out.printf("Done in %.2f sec\n", seconds);
	*/
			
		//병렬처리
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		//시각을 측정하기 위해 사용,,,
		long start = System.currentTimeMillis();
		
		numbers.parallelStream().forEach(number -> {
			try {
				Thread.sleep(1000);
				System.out.println(number + ": " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				System.out.println("중지되었습니다..");
			}	
		});
		
		long duration = (System.currentTimeMillis() - start);
		double seconds = duration / 1000.0;
		System.out.printf("Done in %.2f sec\n", seconds);
	}
}
