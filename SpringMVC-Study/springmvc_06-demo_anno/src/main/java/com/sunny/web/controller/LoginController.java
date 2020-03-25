package com.sunny.web.controller;

import com.sunny.domain.Employee;
import com.sunny.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IEmployeeService service;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        System.out.println("LoginController.login");
        Employee current = service.login(username, password);
        if (current == null){
            session.setAttribute("errorMsg", "账号或密码错误");
            return "redirect:/login.jsp";
        }
        session.setAttribute("user_in_session", current);
        return "redirect:/employee/list";
    }

/*    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        try {
            service.login(username, password);
        } catch (Exception e) {
            session.setAttribute("errorMsg", e.getMessage());
            return "redirect:/login.jsp";
        }
        return "redirect:/employee/list";
    }*/
}
