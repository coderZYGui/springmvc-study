package com.sunny.web.controller;

import com.sunny.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Description: 文件上传处理
 *
 * @author zygui
 * @date 2020/3/7 16:23
 */
@Controller
public class FileUploadController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/save")
    public ModelAndView save(Employee emp, MultipartFile pic) throws Exception{
        System.out.println(emp);
        String filename = pic.getOriginalFilename();
        System.out.println(filename);
        String saveDir = servletContext.getRealPath("/upload");
        Files.copy(pic.getInputStream(), Paths.get(saveDir, filename));
        return null;
    }
}
