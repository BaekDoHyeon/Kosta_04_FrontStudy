package test;
import java.util.Scanner;
/*
6
1 4 4 4 5 3
*/
public class SawonMBTITest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("K전자 신입사원수 입력 >>> ");
		int num = sc.nextInt();//배열의 사이즈
		int[ ] people =new int[num]; //6
		
	    System.out.println("공백을 기준으로 각 사원에 대한 성격 유형을 직접 입력 >>> ");
		//배열 초기화
		for(int i=0; i<people.length; i++) {
			people[i] = sc.nextInt(); //1,4,4,4,5,3(5가지의 타입이 있음)
		}//사람들의 타입 지정이 끝났음...
		
		// 코드 작성 V1 -> 특정 입력값에 에러 발생
//		int answer = 0;
//		int[] counts = new int[num];
//		for (int i : people) { 
//			counts[i]++;
//			if (answer < counts[i]) 
//				answer = i;
//		}
		
		// 코드 작성 V2 -> 문제 해결
		int answer = 0;
		int[] counts = new int[5];
		for (int i : people) { 
			counts[i]++;
			if (answer < counts[i]) 
				answer = i;
		}
	
		System.out.println("정답 :: " + answer);
	}
}