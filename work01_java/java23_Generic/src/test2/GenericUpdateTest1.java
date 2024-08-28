package test2;

import java.util.ArrayList;
import java.util.List;

/*
 * 해당 코드에서는 Generic 기법을 사용
 * 1. 뭐든지 Box 에 담을 수 있다...
 * 2. 꺼낼 때 Object Casting을 안하고 호출하여 사용할 수 있다.
 */

class Box<T> { //T라는 클래스는 실제로 존재하지 않지만 Type을 의미한다.
	T content; //Box에는 T 타입의 내용들이 담겨진다. T 타입은 나중(사용시)에 구체적인 타입으로 대체된다.
	
	public T selectContent() {
		return content;
	}
	
}

public class GenericUpdateTest1 {

	public static void main(String[] args) {
		Box<String> box = new Box<>();
		box.content = "곰인형";
		
		String bear = box.selectContent();
		System.out.println("담겨진 것은 " + bear); // Object Casting을 할 필요 없다.
		
		List<Integer> list = new ArrayList();
		list.add(10); // Auto boxing -> 성능 이슈 있을지도.. 알고리즘의 시간 복잡도 관련?!
		list.add(20);
		list.add(30);
		
		System.out.println(list); // Auto boxing -> 성능 이슈 있을지도.. 알고리즘의 시간 복잡도 관련?!
	}

}
