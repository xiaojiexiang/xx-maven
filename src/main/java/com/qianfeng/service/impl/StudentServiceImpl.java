package com.qianfeng.service.impl;

import java.util.Iterator;
import java.util.Map;

import com.qianfeng.dao.IStudentDao;
import com.qianfeng.pojo.po.Student;
import com.qianfeng.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao sdao;

	public IStudentDao getSdao() {
		return sdao;
	}

	public void setSdao(IStudentDao sdao) {
		this.sdao = sdao;
	}

	@Override
	public Student findStudentById(Integer id) {
		Map<Integer, Student> map = sdao.studentInfo();
		Iterator it = map.keySet().iterator();
		Student student = null;
		while (it.hasNext()) {
			if (id == it.next()) {
				student = map.get(id);
				return student;
			}

		}
		return student;
	}

}
