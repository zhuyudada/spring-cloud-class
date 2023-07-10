package com.newer.dao;

import com.newer.model.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CartDao extends JpaRepository<Cart , Integer> {
    @Query(nativeQuery = true , value = "select * from d_cart where u_id=?1")
    List<Cart> getAllcart(@Param(value = "uid")int uid);

    //插入一条购物车
    @Query(nativeQuery = true, value = "insert into d_cart values (seq_d_cart.nextval,?1,?2,?3,?4,?5)")
    int intcart(@Param(value = "goodsname")String goodsname, @Param(value
            ="number")int number, @Param(value = "price")int price, @Param(value
            ="goodid")int goodid, @Param(value = "uid")int uid);

    //修改购物车商品数量
    @Query(nativeQuery = true , value = "update d_cart set c_number=?1 where id=?2")
    int updateCart(@Param(value = "number") int number,@Param(value = "id") int id);

}
