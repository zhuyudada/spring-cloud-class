package com.newer.controller;

import com.newer.dao.CartDao;
import com.newer.dao.GoodsDao;

import com.newer.model.Cart;
import com.newer.model.Goods;
import com.newer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController implements ConsumerService {

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    CartDao cartDao;

    @Override
    public List<Goods> selectAll() {
        return goodsDao.selectAll();
    }

    @Override
    public Goods selectById(Integer gid) {
        return goodsDao.selectById(gid);
    }

    @Override
    public List<Goods> getOnegoods(String gname) {
        return goodsDao.selectByGname(gname);
    }

    @Override
    public int updateCart(int number, int id) {
        return cartDao.updateCart(number , id);
    }

    @Override
    public int intcart(String goodsname, int number, int price, int goodid, int uid) {
        return cartDao.intcart(goodsname,number,price,price,uid);
    }

    @Override
    public List<Cart> getAllcart(int uid) {
        return cartDao.getAllcart(uid);
    }


}
