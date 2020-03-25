package com.sunny.service.impl;


import com.sunny.dao.IEmployeeDAO;
import com.sunny.domain.Employee;
import com.sunny.service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDAO dao;

	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
	}

	public void save(Employee emp) {
		dao.save(emp);
	}

	public void update(Employee emp) {
		dao.update(emp);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public Employee get(Long id) {
		return dao.get(id);
	}

	public List<Employee> listAll() {
		return dao.listAll();
	}

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
