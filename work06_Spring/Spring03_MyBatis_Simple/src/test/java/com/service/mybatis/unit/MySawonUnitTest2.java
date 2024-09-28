package com.service.mybatis.unit;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonUnitTest2 {
	
	public static void main(String[] args) throws IOException {
		SqlSessionFactory factory = FactoryService.getFactory();
		
		SqlSession session = factory.openSession();
		
		System.out.println("SqlSession...Creating...");
		
		session.selectList("SawonMapper.sawonList")
				.forEach(c -> System.out.println(c));
		
		session.commit();
		session.close();
	}
}
