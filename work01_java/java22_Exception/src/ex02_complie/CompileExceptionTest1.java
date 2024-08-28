package ex02_complie;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading {
	public void readFile(String fileName) {
		System.out.println("2. readFile calling...");
		
		//자바에서 파일을 읽어들이기 위해서는 FileReader 객체를 생성
		try {
			FileReader reader = new FileReader(fileName);
			System.out.println("파일을 성공적으로 찾았습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
//			System.out.println(e);
//			e.printStackTrace(); // 정상 종료 처리 -> 이건 몰랐네... -> 개발 할때에만 사용하는데 요즘은 개발시에도 사용하지 않는다고 한다...
		}
	}
}

public class CompileExceptionTest1 {

	public static void main(String[] args) {
		System.out.println("1. FileReading 객체 생성...");
		FileReading fr = new FileReading();
		
		fr.readFile("text.txt");
		
		System.out.println("3. 파일을 잘 읽어들였습니다...");
	}
	
}