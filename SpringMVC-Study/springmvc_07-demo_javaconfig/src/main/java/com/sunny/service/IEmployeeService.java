package com.sunny.service;


import com.sunny.domain.Employee;

import java.util.List;

public interface IEmployeeService {
	void save(Employee emp);

	void update(Employee emp);

	void delete(Long id);

	Employee get(Long id);

	List<Employee> listAll();

	Employee login(String username, String password);

	/*void login(String username, String password);*/

}
