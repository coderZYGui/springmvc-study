package com.sunny.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
// 窄化处理: 比如想访问/test1,必须在url中输入 /response/test1
@RequestMapping("/response")
public class HandleResponseController {
    //返回void类型,此时可以把Controller方法当做Servlet来使用
    @RequestMapping("/test1")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //请求转发:
        request.getRequestDispatcher("").forward(request, response);
        //URL重定向
        response.sendRedirect("");
        //设置共享数据
        request.setAttribute("", "");
        //输出JSON格式
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println("");
    }

    //返回ModelAndView
    @RequestMapping("/test2")
    public ModelAndView returnMv() {
        ModelAndView mv = new ModelAndView();
        //设置共享数据的key和value
        mv.addObject("msg", "返回ModelAndView");
        //设置共享数据value,此时会把value类型的首字母作为key:string
        mv.addObject("你好桂朝阳");
        mv.setViewName("welcome");
        return mv;
    }
    //前缀:/WEB-INF/views/
    //后缀:.jsp
    //物理视图= 前缀+逻辑视图名+后缀
	/*
	 <!-- 配置视图解析器 -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/views/"/>
		<property name="suffix" value=".jsp"/>
	</bean>ss
	 */

    // 返回String,逻辑视图名称,此时需要结合Model类型的参数一起使用
    @RequestMapping("/test3")
    public String returnStr(Model model) {
        model.addAttribute("msg", "返回String");
        model.addAttribute("朝阳你好String");
        // 返回的就是视图名称
        return "welcome";
    }

    // 请求转发,浏览器地址栏不改变,可以共享请求的数据
    //原理:request.getRequestDispatcher("").forward(request, response);
    @RequestMapping("/test4")
    public String test4(Model model) {
        return "forward:/hello.html";
    }

    // URL重定向,浏览器地址栏会改变,不能共享请求中的数据
    // 原理: response.sendRedirect("");
    @RequestMapping("/test5")
    public String test5(Model model) {
        return "redirect:/hello.html";
    }

    /*
	 	请求转发和URL重定向的选择:
	 					请求转发			URL重定向
	 	-----------------------------------------
	 	 地址栏			不会				    会变
	 	 共享数据			可以				不能?
	 	表单重复提交		导致				不会


	 	请求资源的路径问题(转发、重定向都一样): 以后访问资源的时候,都使用/开头.
	 		重定向 redirect:/hello.html 和 redirect:hello.html

	 			访问资源的时候前面带上/,表示绝对路径,从根路径开始去寻找资源.
	 			访问资源的时候签名不加/,表示相对路径,从上一级上下文路径中去寻找资源.

	 			/response/test5----->"redirect:/hello.html";--->localhost:/hello.html
	 			/response/test5----->"redirect: hello.html";--->localhost:/response/hello.html


	 	传统的方式,在URL重定向的时候,因为是两次不同的请求,所以不能共享请求中的数据.
	 	在开发中有的时候,真的需要重定向跳转后共享数据.
	 	spring3.1开始 提供了Flash属性.,只能使用从Controller重定向到Controller,不能到JSP.
	 */

    @RequestMapping("/a")
    public String a(RedirectAttributes ra) {
        ra.addAttribute("msg1", "gzy");
        ra.addFlashAttribute("msg2", "gzy");
        return "redirect:/response/b";
    }

    @RequestMapping("/b")
    public String b(String msg1, @ModelAttribute("msg2")String msg2) {
        System.out.println("msg1:" + msg1);
        System.out.println("msg2:" + msg2);
        return null;
    }



    /*
    // 这种重定向共享数据一般不会用,共享的数据在地址栏中
    @RequestMapping("/a")
    public String a(RedirectAttributes ra) {
        ra.addAttribute("msg1", "gzy");
        return "redirect:/response/b";
    }

    @RequestMapping("/b")
    public String b(String msg1) {
        System.out.println("msg1:" + msg1);
        return null;
    }
     */



}
