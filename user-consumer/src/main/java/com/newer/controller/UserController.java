package com.newer.controller;

import com.newer.service.ProductService;
import com.newer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/index")
    public ModelAndView tologin(ModelAndView modelAndView) {
        modelAndView.setViewName("/login");
        return modelAndView;
    }
     //跳转登录界面
    @GetMapping(value = "/tologin")
    public String tologin() {
        return "login";
    }
     // 跳转注册界面
    @GetMapping(value = "/toregister")
    public String toregister() {
        return "register";
    }
     // 用户登录
     @GetMapping(value = "login")
     public String login(String uname, String upassword, HttpServletRequest request) {
         System.out.println(userService.login(uname,upassword));
         if (userService.login(uname,upassword) != null) {
             if (userService.login(uname,upassword).getUpassword().equals(upassword)){
                 System.out.println("---");
                 HttpSession session = request.getSession(true);
                 session.setAttribute("user", userService.login(uname,upassword));  //将登陆者信息存入session
                 return "redirect:http://localhost:8896/getAll?uaccount="+userService.login(uname,upassword).getUaccount()+"&upasswoed="+userService.login(uname,upassword).getUpassword();
             }
         }
         // request.setAttribute("mag","账号密码错误");
         System.out.print("登录成功");
         return "login";
    }
    //用户注册
//    @GetMapping(value = "register")
//    public String register(HttpServletRequest request,String upassword,String uname,String usex) {
//       if(userService.register(upassword, uname, usex)>0){
//           System.out.print("注册成功");
//           return "login";
//       }
//        System.out.print("注册失败");
//        return "register";
//    }
}