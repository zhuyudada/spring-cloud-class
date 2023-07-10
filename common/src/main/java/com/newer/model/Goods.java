package com.newer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Classname Goods
 * @Description TODO
 * @Date 2019-9-25 11:30
 * @Created by CrazyStone
 */
@Data
@Entity
@Table(name = "d_goods")
public class Goods {
    @Id
    private Integer gid;
    private Integer gprice;
    private String gname;
    private String gdetails;
    private  Integer types;
    private String gremain;

}
