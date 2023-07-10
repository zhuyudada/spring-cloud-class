package com.newer.service;

import com.newer.model.User;
import org.springframework.web.bind.annotation.*;
public interface ProductService {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    User login(@RequestParam("uaccount") String uaccount,@RequestParam("upassword") String upassword);

//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    int register(@RequestHeader("upassword") String upassword, @RequestHeader("uname") String uname, @RequestHeader("usex") String usex);

}
