package com.newer.dao;

import com.newer.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsDao extends JpaRepository<Goods,Integer> {

    @Query(nativeQuery = true,value = "select * from d_goods")
    List<Goods> selectAll();

    @Query(nativeQuery = true, value = "select * from d_goods where gid=?1")
    Goods selectById(@Param(value = "gid") Integer gid);
    @Query(nativeQuery = true,value = "select * from d_goods where gname like %?1%")
    List<Goods> selectByGname(@Param(value = "gname") String gname);

}
