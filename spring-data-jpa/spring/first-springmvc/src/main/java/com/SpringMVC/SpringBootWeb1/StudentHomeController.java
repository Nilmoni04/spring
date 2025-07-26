package com.SpringMVC.SpringBootWeb1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentHomeController {

    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }
    @RequestMapping("/student")
    public String home() {
        System.out.println("Student Home method called...");
        return "student.jsp";
    }

    @RequestMapping("/addStudent")
    public String add(@ModelAttribute Student student) {
        System.out.println("Method called!");
//        Student s = new Student();
//        s.setName(name);
//        s.setRoll(roll);
        return "studentdata.jsp";
    }
}
