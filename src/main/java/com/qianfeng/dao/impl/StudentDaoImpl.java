package com.qianfeng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import com.qianfeng.dao.IStudentDao;
import com.qianfeng.pojo.po.Student;
import com.qianfeng.utils.C3P0Utils;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Override
	public List<Student> studentInfo() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from student";
		List<Student> list = qr.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
			
	}

}
