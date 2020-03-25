package com.sunny.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello") //地址栏url来找该标志,不能重复
    public ModelAndView sayHello(){
        System.out.println("HelloController.sayHello");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("msg", "使用注解开发SpringMVC");
        return mv;
    }

    @RequestMapping("/hello2")
    public String sayMVC(Model model){
        System.out.println("HelloController.sayMVC");
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg", "使用注解开发SpringMVC2");
        return "welcome"; //web-inf/jsp/hello.jsp
    }

    //返回ModelAndView
    @RequestMapping("/test3")
    public ModelAndView test3() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "返回ModelAndView");//设置共享数据的key和value
        mv.addObject("你好,白骆驼!");//设置共享数据value,此时会把value类型的首字母作为key:string
        mv.setViewName("welcome");
        return mv;
    }
}
