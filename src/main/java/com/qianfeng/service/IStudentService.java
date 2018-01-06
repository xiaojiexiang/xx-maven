package com.qianfeng.service;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.pojo.po.Student;

public interface IStudentService {
	public Student findStudentById(Integer sid); 
	public List<Student> studentInfo() throws SQLException;
}
