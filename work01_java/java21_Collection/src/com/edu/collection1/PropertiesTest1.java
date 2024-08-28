package com.edu.collection1;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

//시스템위에 탑재된 자바관련 환경변수들이 어떤값들이 있는지
//전부다 가져와서 콘솔로 출력
public class PropertiesTest1 {
	public static void main(String[] args) {
		
		Properties p = System.getProperties();
		
		//1. Enumeration 사용법
//		Enumeration en =  p.propertyNames();
//		//키를 뽑고 키에 해당하는 값을 뽑는다..
//		while (en.hasMoreElements()) { //있으면 true, 없다면 false -> 값이 없을때까지 반복 진행
//			String key = (String) en.nextElement();
//			String value = (String) p.get(key);
//			
//			System.out.println(key + " : " + value);
//		}
		
		//2. Iterator 사용법
//		Set set = p.keySet();
//		Iterator<String> it = set.iterator();
//		while (it.hasNext()) {
//			String key = it.next();
//			String value = (String) p.get(key);
//			System.out.println(key + " : " + value);
//		}
		
		//3. Iterator 사용법 V2
//		Iterator it = p.keySet().iterator();
//		while (it.hasNext()) {
//			String key = (String) it.next();
//			String value = (String) p.get(key);
//			System.out.println(key + " : " + value);
//		}
		
		//4. for
//		for(Object key : p.keySet()) {
//			String value = (String) p.get(key);
//			System.out.println(key + " : " + value);
//		}
		
		//5. forEach. 람다식. java 1.8 버전 이상에서만 사용 가능..
		p.forEach((key, value) -> 
			System.out.println(key + " : " + value)
		);
	}
}




















