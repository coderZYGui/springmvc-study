package com.sunny.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 前台往后台传日期的时候(请求)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 后台往前台响应JSON格式的数据
    private Date hiredate;
}
