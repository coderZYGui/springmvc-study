package com.sunny.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Employee {
	private Long id;
	private String username;
	private String password;
	private Integer age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;
}
