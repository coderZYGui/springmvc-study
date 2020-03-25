package com.sunny.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

// 操作其他的请求信息
@Controller
@RequestMapping("/other")
@SessionAttributes("errorMsg")
public class OtherController {

    // 获取请求头中的User-Agent和Cookie信息
    // 以前的方式
    @RequestMapping("zy1")
    public void test0(HttpServletRequest request){
        String header = request.getHeader("User-Agent");
        String jsessionid = request.getHeader("Cookie");
        System.out.println(header);
        System.out.println(jsessionid);
    }

    // 现在的方式
    @RequestMapping("zy2")
    public void test1(@RequestHeader("User-Agent") String userAgent, @CookieValue("JSESSIONID") String cookieName){
        System.out.println("User-Agent:" + userAgent);
        System.out.println("cookieName" + cookieName);
    }


    // 操作HttpSession;
    // 默认情况下Model数据是放到request中共享的,如果我想在session共享---->SessionAttributes注解
    @RequestMapping("/zy3")
    public String test2(Model model){
        model.addAttribute("errorMsg", "错误信息!");
        //默认肯定不能共享数据的,因为是重定向;之前讲过的那个Flash共享也仅仅只是在Controller之间共享
        return "redirect:/abc.jsp";
    }
}
