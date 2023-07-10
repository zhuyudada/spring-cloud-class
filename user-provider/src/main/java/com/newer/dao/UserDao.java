package com.newer.dao;

import com.newer.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,String> {

    @Query(nativeQuery = true,value = "select * from d_user where uaccount= ?1 and upassword= ?2")
    User login(String uaccount,String upassword);



}
