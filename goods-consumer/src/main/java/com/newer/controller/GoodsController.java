package com.newer.controller;

import com.newer.model.Cart;
import com.newer.model.Goods;
import com.newer.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    //首页查询全部商品并分类显示
    @GetMapping(value = "/getAll")
    public String getAll(HttpServletRequest request, String uaccount,
                         String upasswoed, String uname, String usex, HttpSession session) {
        session.setAttribute("uaccount", uaccount);
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();
        List<Goods> list = goodsService.selectAll();
        for (Goods newgoods : list) {
            System.out.print(newgoods.getTypes());
            if (newgoods.getTypes().equals(1)) {
                goods1.add(newgoods);
            }
            if (newgoods.getTypes().equals(2)) {
                goods2.add(newgoods);
            }
            if (newgoods.getTypes().equals(0)) {
                goods3.add(newgoods);
            }
            if (newgoods.getTypes().equals(3)) {
                goods4.add(newgoods);
            }
        }
        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);
        return "index";
    }

    //商品详情-即根据ID查询单个商品
    @GetMapping(value = "/detail")
    public String detail(HttpServletRequest request, int gid) {
        request.setAttribute("detail", goodsService.selectById(gid));
        return "detail";
    }

    //商品首页搜索-根据名称模糊查找商品
    @GetMapping(value = "/getOne")
    public String getOne(HttpServletRequest request, String name) {
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();
        List<Goods> oldgoods = goodsService.getOnegoods(name);
        for (Goods newgoods : oldgoods) {
            System.out.print(newgoods.getTypes());
            if (newgoods.getTypes().equals(1)) {
                goods1.add(newgoods);
            }
            if (newgoods.getTypes().equals(2)) {
                goods2.add(newgoods);
            }
            if (newgoods.getTypes().equals(0)) {
                goods3.add(newgoods);
            }
            if (newgoods.getTypes().equals(3)) {
                goods4.add(newgoods);
            }
        }
        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);
        return "index";
    }




    @GetMapping(value = "cart")
    public  String cart(HttpServletRequest request,String name,String price,String che,String number,HttpSession session){
        String uid = (String)session.getAttribute("uaccount");
        List<Cart> usercart= goodsService.getAllcart(Integer.parseInt(uid));
        int n = Integer.parseInt(price);
        for (int i=0;i<usercart.size();i++){
            if (usercart.get(i).getGoodid()==Integer.parseInt(che)){
                goodsService.updateCart(Integer.parseInt(number),usercart.get(i).getId());
                return  "redirect:/cartAll";
            }
        }
        goodsService.intcart(name, Integer.parseInt(number),n,Integer.parseInt(che),Integer.parseInt(uid));
        return "redirect:/cartAll";
    }

    @GetMapping(value = "cartAll")
    public  String cartAll(HttpServletRequest request,HttpSession session){
        String uid = (String) session.getAttribute("uaccount");
        request.setAttribute("carts", goodsService.getAllcart(Integer.parseInt(uid)));
        return "Settle";
    }


}
