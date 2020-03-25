package com.sunny.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class Employee {

	private Long id;

	@NotNull(message = "用户名不能为空")
	@Size(max = 10, min = 4, message = "用户名在4-10位之间")
	private String username;

	@NotNull(message = "密码不能为空")
	@Size(max = 10, min = 4, message = "密码在4-10位之间")
	private String password;

	@NotNull(message = "年龄不能为空")
	@Min(value = 18, message = "年龄最小值为18")
	@Max(value = 60, message = "年龄最大值为60")
	private Integer age;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;
}
