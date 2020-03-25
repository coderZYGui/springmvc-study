package com.sunny.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Description: 处理全局的异常,当发现异常,自动跳转到error.jsp
 *
 * @author zygui
 * @date 2020/3/7 10:21
 */

@ControllerAdvice
public class HandleExceptionAdviceController {

    //@ExceptionHandler(XxxException.class) // 对XxxException异常做处理
    @ExceptionHandler // 默认就是对Exception做处理
    public String error(Model model, Exception ex){
        model.addAttribute("errorMsg", ex.getMessage());
        return "/commons/error";
    }
}
