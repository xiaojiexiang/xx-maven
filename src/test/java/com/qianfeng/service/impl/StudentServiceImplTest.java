package com.qianfeng.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qianfeng.pojo.po.Student;
import com.qianfeng.service.IStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceImplTest {
	@Autowired
	private IStudentService service;
	
	
	public IStudentService getService() {
		return service;
	}


	public void setService(IStudentService service) {
		this.service = service;
	}


	@Test
	public void test1(){
		
		List<Student> stuList = null;
		try {
			stuList = service.studentInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(stuList);
	}
	
	@Test
	public void findStudentById(){
		Student student = service.findStudentById(1);
		System.out.println(student);
	}
}
