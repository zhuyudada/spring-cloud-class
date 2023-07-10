package com.newer.service;

import com.newer.model.Cart;
import com.newer.model.Goods;
import com.newer.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ConsumerService {

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    List<Goods> selectAll();

    @RequestMapping(value = "/selectById" , method = RequestMethod.GET)
    Goods selectById(@RequestParam(value = "gid") Integer gid);

    @RequestMapping(value = "/getOnegoods",method = RequestMethod.GET)
    public List<Goods> getOnegoods(@RequestParam(value = "gname") String gname);


    @RequestMapping(value = "/updateCart",method = RequestMethod.GET)
    public int updateCart(@RequestParam(value = "number") int number, @RequestParam(value = "id") int id);
    @RequestMapping(value = "/intcart",method = RequestMethod.GET)
    public int intcart(@RequestParam(value = "goodsname") String goodsname, @RequestParam(value = "number") int number, @RequestParam(value = "price") int price, @RequestParam(value = "goodid") int goodid, @RequestParam(value = "uid") int uid);
    @RequestMapping(value = "/getAllcart",method = RequestMethod.GET)
    public List<Cart> getAllcart(@RequestParam(value = "uid") int uid);

}
