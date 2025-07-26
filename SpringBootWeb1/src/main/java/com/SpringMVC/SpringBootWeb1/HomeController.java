package com.SpringMVC.SpringBootWeb1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        System.out.println("Home method called...");
        return "index.jsp";
    }


//    @RequestMapping("add")
//    public String add(HttpServletRequest req, HttpSession session) {
//        System.out.println("Add method called!");
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1+num2;
//        session.setAttribute("result", result);
//        return "result.jsp";
//    }

//    We can simplify this
// @RequestMapping("add")
// public String add(@RequestParam("num1") int num1,@RequestParam("num2") int num2, HttpSession session) {
//    System.out.println("Add method called!");
//    int result = num1+num2;
//    session.setAttribute("result", result);
//    return "result.jsp";
// }

 //Instead of Httpsession, we can use the model object, which is the main purpose of MVC project
 @RequestMapping("/add")
 public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv) {
     System.out.println("Add method called!");
     int result = num1+num2;
     mv.addObject("result", result);
     mv.setViewName("result.jsp");
     return mv;
 }
}
