package com.newer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Classname User
 * @Description TODO
 * @Date 2019-9-10 9:16
 * @Created by CrazyStone
 */
@Data
@Entity
@Table(name = "d_user")
public class User {
    @Id
    private String uaccount;
    private String upassword;
    private String uname;
    private String usex;

}
