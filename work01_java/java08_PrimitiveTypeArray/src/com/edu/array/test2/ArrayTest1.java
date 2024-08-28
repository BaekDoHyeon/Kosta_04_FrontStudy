package com.edu.array.test2;
/*
 * 배열은 한번 잡은 사이즈는 바뀔수 없다.
 * 사이즈를 변경하는 순간 새로운 배열이 생성된다.
 */
public class ArrayTest1 {

	public static void main(String[] args) {
		int[] members = {1, 2, 3, 4, 5};
		
		members = new int[8];
		members[5] = 6;
		members[6] = 7;
		members[7] = 8;
		
		for(int member : members) System.out.println(member);


	}

}
