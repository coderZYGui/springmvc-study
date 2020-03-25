package com.sunny.request;

import com.sunny.vo.FormBean;
import com.sunny.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping("/request")
public class HandleRequestController {
    /*
        如何在Controller中获取请求中的信息呢?
     */


    // 也可以通过DI注入的方式,因为Controller是单例的,多线程不安全(不建议使用)
    @Autowired
    private ServletContext servletContext;

    // 可以通过参数来操作Servlet的api
    @RequestMapping("/test1")
    public void test1(HttpServletRequest request, HttpServletResponse responser, HttpSession session) {
        System.out.println(request.getParameter("username"));
        System.out.println(request);
        System.out.println(responser);
        System.out.println(session);
        System.out.println(this.servletContext);
    }

    // 获取请求参数,保证请求参数名称和Controller方法的形参(入参)同名;
    // 这样就可以获得请求的参数内容; 名字不同,得不到
    @RequestMapping("/test2")
    public void test2(String username, int age) {
        System.out.println("username:" + username);
        System.out.println("age:" + age);
    }

    // 如果请求参数名称和形参名称不同 ==> 使用RequestParam注解
    // 使用@RequestMapping注解后,名字不同,也可以获取,请求参数的内容
    @RequestMapping("/test3")
    public void test3(@RequestParam("name") String username, @RequestParam(value = "age") Integer age) {
        System.out.println("username:" + username);
        System.out.println("age:" + age);
    }

    //RESTful风格传参
    //      /delete?id=11   以前的方式
    //      /delete/11      RESTfull方式
    // @PathVariable: 可以将URL中占位符绑定到方法的形参中
    @RequestMapping("delete/{id}")
    public void test4(@PathVariable("id") Long id){
        System.out.println("使用RESTful风格传参id为:"+id);
    }


    // 接受一个参数有多个值的情况
    // 批量删除; /batchDelete?ids=10&ids=20&ids=30
    // 使用数组: 可以直接接收传递的多个参数
    @RequestMapping("/batchDelete")
    public void batchDelete(Long[] ids){
        System.out.println(Arrays.asList(ids));
    }
    // 使用集合List: 不能直接接受,可以在对象中存在一个集合
    @RequestMapping("/batchDelete2")
    public void batchDelete2(FormBean fb){
        System.out.println(fb.getIds());
    }
    //操作一个参数有多个值的情况,一般直接使用数组接受就可以了,或者使用JavaBean对象来封装数据.


    //把数据直接封装到JavaBean对象
    @RequestMapping("/test4")
    public void test4(User u) {
        System.out.println(u);
    }
}
