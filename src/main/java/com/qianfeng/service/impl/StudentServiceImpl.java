package com.qianfeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.IStudentDao;
import com.qianfeng.pojo.po.Student;
import com.qianfeng.service.IStudentService;
@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao sdao;

	public IStudentDao getSdao() {
		return sdao;
	}

	public void setSdao(IStudentDao sdao) {
		this.sdao = sdao;
	}

	
	

	@Override
	public Student findStudentById(Integer id) {
		return sdao.findStudentById(id);
	}

	@Override
	public List<Student> studentInfo() {
		return sdao.studentInfo();
		
	}

}
