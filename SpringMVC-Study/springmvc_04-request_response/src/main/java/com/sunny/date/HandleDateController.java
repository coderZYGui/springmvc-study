package com.sunny.date;

import com.sunny.vo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/date")
public class HandleDateController {
    // 从前台--->后台传递参数: String ---> java.util.Date  // http://localhost:8080/date/test1?d=2010-11-1
    @RequestMapping("/test1")
    public ModelAndView test1(@DateTimeFormat(pattern = "yyyy-MM-dd") Date d){
        System.out.println(d);
        return null;
    }

    // http://localhost:8080/date/test2?id=2&username=zy&age=23&hiredate=2020-2-1
    @RequestMapping("/test2")
    public ModelAndView test2(User user){
        System.out.println(user);
        return null;
    }
}
