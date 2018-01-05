package com.qianfeng.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.qianfeng.dao.IStudentDao;
import com.qianfeng.pojo.po.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public Map<Integer, Student> studentInfo() {
		Map<Integer, Student> stuMap = new HashMap<>();
		Student stu1 = new Student("zhangsan",11);
		Student stu2 = new Student("lisi",22);
		stuMap.put(1, stu1);
		stuMap.put(2, stu2);
		return stuMap;
	}

}
