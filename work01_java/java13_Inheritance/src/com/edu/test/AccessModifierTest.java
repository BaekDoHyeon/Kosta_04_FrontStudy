package com.edu.test;

import com.edu.child.Child;
import com.edu.parent.Parent;

public class AccessModifierTest {

	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		Parent pc = new Child();
		
		p.access();
		c.access();
		pc.access();
		
		System.out.println();
		
		c.childAccess();
		//pc.childAccess(); -> 자식에만 존재하는 요소는 사용 불가...
	}
}