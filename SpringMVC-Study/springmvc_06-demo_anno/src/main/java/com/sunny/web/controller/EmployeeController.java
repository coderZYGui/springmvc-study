package com.sunny.web.controller;

import com.sunny.domain.Employee;
import com.sunny.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/list")
    public String list(Model model) {
        //int a = 1 / 0;
        // 共享数据到list界面
        model.addAttribute("employees", employeeService.listAll());
        return "employee/list"; // 跳转到list界面
    }

    // 新增员工
    @RequestMapping("/input")
    public String input(Model model, Long id) {
        if (id != null) {
            model.addAttribute("employee", employeeService.get(id));
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "employee/input";
    }

/*    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Employee emp){
        if (emp.getId() == null){
            employeeService.save(emp);
        } else {
            employeeService.update(emp);
        }
        return "redirect:/employee/list";
    }*/

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid Employee emp, BindingResult bindingResult, Model model) {

        List<ObjectError> errors = bindingResult.getAllErrors();
        if (errors.size() > 0) {
            model.addAttribute("errors", errors);
            return "employee/input";
        }

        if (emp.getId() == null) {
            employeeService.save(emp);
        } else {
            employeeService.update(emp);
        }
        return "redirect:/employee/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            employeeService.delete(id);
        }
        return "redirect:/employee/list";
    }
}
