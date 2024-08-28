package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
}

public class Stream01StudentList {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
					new Student("SCOTT", 90),
					new Student("BLAKE", 92),
					new Student("SMITH", 83)
		);
		
		Stream<Student> studentStream = students.stream();
		
		//중간처리 연산자 mapToInt...학생 객체를 점수로 매핑하는 기능
		//IntStream(점수만으로 이루어진 새로운 스트림)를 반환한다.
		
		//중간 처리
		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
		
		//최종 처리
		double avg = scoreStream.average().getAsDouble();
		System.out.println("Result Avg 1 " + avg);
		
		System.out.println();
		
		System.out.println("=========== Method Chaining ===========");
		avg = students.stream()
				.mapToInt(student -> student.getScore())
				.average()
				.getAsDouble();
		System.out.println("Result Avg 2 " + avg);
		
		System.out.println("\n===================== map =====================");
		// [map] Stream내 값들을 변환해서 새로운 스트림을 생성하는 기능
		long count = students.stream()
				.map(i -> i.getName())
				.peek(System.out::println)
				.count();
		System.out.println("학생수 " + count);
	}
}








