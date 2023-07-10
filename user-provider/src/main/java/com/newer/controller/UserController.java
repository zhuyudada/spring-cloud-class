package com.newer.controller;

import com.newer.dao.UserDao;
import com.newer.model.User;
import com.newer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class UserController implements ProductService {

    @Autowired
    UserDao userDao;

//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public int register(@RequestParam(value = "upassword")String
//                                upassword, @RequestParam(value = "uname")String uname,
//                        @RequestParam(value = "usex") String usex){
//        return userDao.register(upassword,uname,usex);
//    }
@RequestMapping(value = "/login",method = RequestMethod.GET)
public User login(@RequestParam("uaccount") String uaccount,@RequestParam("upassword") String upassword ){
    return userDao.login(uaccount,upassword);
}

//    public User login(@RequestParam("uname") String uname){
//        System.out.println(uname);
//        return userDao.login(uname);
//    }
}
