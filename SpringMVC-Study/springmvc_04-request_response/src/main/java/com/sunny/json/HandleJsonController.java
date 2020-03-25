package com.sunny.json;

import com.sunny.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

// 处理JSON
@Controller
@RequestMapping("/json")
public class HandleJsonController {

	/*
	 	处理JSON的注解:
	 		ResponseBody: 处理响应,把对象转换为JSON字符串.
	 			贴到方法上:只针对当前方法做JSON处理.
	 			贴到类上   : 会对当前类中所有的方法做JSON处理.

	 		RestController = Controller + ResponseBody

	 		RequestBody: 处理请求,用于读取HTTP请求的内容,把JSON格式的请求数据封装成对象.

	 		一般的请求的数据格式:
	 			application/x-www-form-urlencoded: 传统的key-value格式,处理起来非常方便. 不需要RequestBody都可以,贴上也可以.
	 			application/multipart:文件上传的请求,SpringMVC装设设计模式,.既能处理文件上传,也能处理普通表单数据.
	 			application/json:	参数是JSON格式的,此时必须使用RequestBody.

	 */

	// 把单个对象/Map转换为JSON格式
    @RequestMapping("/test1")
    @ResponseBody
    public User test1() {
        User u = new User();
        u.setUsername("桂朝阳");
        u.setAge(22);
        return u;
    }

    // 把集合转为JSON格式
    @RequestMapping("/test2")
    @ResponseBody
    public List<User> test2() {
        User u = new User();
        u.setUsername("桂阳");
        u.setAge(22);
        return Arrays.asList(u, u, u);
    }

    @RequestMapping("/test3")
    @ResponseBody
    public User test3(){
        User user = new User();
        user.setUsername("will");
        user.setAge(82);
        user.setHiredate(new Date());
        return user;
    }
}
