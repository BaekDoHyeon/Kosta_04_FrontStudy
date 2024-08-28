package ex02_complie;
// 예외를 처리하는 방법중 throws
// 즉각적으로 예외를 처리하지 않고 호출한 지점으로 예외를 던지는 방법
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

class FileReading3 {
	public void readFile(String fileName) throws FileNotFoundException, IOException {
		System.out.println("2. readFile calling...");
		FileReader reader = null;
		
		//자바에서 파일을 읽어들이기 위해서는 FileReader 객체를 생성
		try {
			reader = new FileReader(fileName); //자원을 열었다는 의미 
			System.out.println("파일을 성공적으로 찾았습니다.");
		} finally {
				System.out.println("자원 반환...");
				reader.close();
		}
	}
}

public class CompileExceptionTest3 {

	public static void main(String[] args) {
		System.out.println("1. FileReading 객체 생성...");
		FileReading3 fr = new FileReading3();
		
		try {
			fr.readFile("text.txt");
		} catch (FileNotFoundException e) {
			System.out.println("잡았다...");
		} catch (IOException e) {
			System.out.println("잡았다...");
		}
		
		
		System.out.println("3. 파일을 잘 읽어들였습니다...");
	}
	
}