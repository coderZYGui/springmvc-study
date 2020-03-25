package com.sunny.service.impl;


import com.sunny.dao.IEmployeeDAO;
import com.sunny.domain.Employee;
import com.sunny.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeServiceImpl")
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {


	@Autowired
	private IEmployeeDAO dao;


	public void save(Employee emp) {
		dao.save(emp);
		//int a = 1/0;
	}

	public void update(Employee emp) {
		dao.update(emp);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public List<Employee> listAll() {
		return dao.listAll();
	}

	@Transactional(readOnly = true)
	public Employee get(Long id) {
		return dao.get(id);
	}

	@Transactional(readOnly = true)
	public Employee login(String username, String password) {
		return dao.login(username, password);
	}

/*	public void login(String username, String password){
		Employee current = dao.login(username, password);
		if (current == null){
			throw new RuntimeException("账号或密码错误!");
		}
		UserContext.setCurrentUser(current);
	}*/
}
