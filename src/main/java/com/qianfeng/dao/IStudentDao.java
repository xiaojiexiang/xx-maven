package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qianfeng.pojo.po.Student;

public interface IStudentDao {
	public List<Student> studentInfo() throws SQLException;
}
