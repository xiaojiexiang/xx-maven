package com.qianfeng.dao;

import java.util.List;


import com.qianfeng.pojo.po.Student;

public interface IStudentDao {
	public List<Student> studentInfo();
	public Student findStudentById(int sid);
}
