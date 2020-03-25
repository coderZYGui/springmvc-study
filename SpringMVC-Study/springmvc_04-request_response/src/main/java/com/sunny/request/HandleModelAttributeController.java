package com.sunny.request;

import com.sunny.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request")
public class HandleModelAttributeController {

    /*
        ModelAttribute注解
        1: 给共享的Model数据设置key名,贴在形参上,也可以贴在方法上
            针对复合类型(非简单类型)参数,缺省情况下就会放到model中(共享),缺省的key就是类型首字母小写
            我们也可以在参数上贴@ModelAttribute,设置一个model的key名
        2:
     */

    @RequestMapping("/zy1")
    public String test1(User u){
        System.out.println(u);
        return "welcome";
    }
    @RequestMapping("/zy2")
    public String test2(@ModelAttribute("zyuser") User u){
        System.out.println(u);
        return "welcome";
    }

}
