package com.qianfeng.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qianfeng.dao.impl.StudentDaoImpl;
import com.qianfeng.pojo.po.Student;

public class StudentServiceImplTest {
	
	
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentServiceImpl service = ac.getBean("stuService",StudentServiceImpl.class);
		StudentDaoImpl sdao = ac.getBean("stuDao", StudentDaoImpl.class);
		service.setSdao(sdao);
		Student student = service.findStudentById(1);
		System.out.println(student.getName()+","+student.getAge());
	}
}
