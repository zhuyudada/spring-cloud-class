package com.newer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Cart
 * @Description TODO
 * @Date 2019-10-11 18:28
 * @Created by CrazyStone
 */
@Data
@Entity
@Table(name = "d_cart")
public class Cart {
    @Id
    private Integer id;
    private String goodsname;
    private Integer number;
    private Integer price;
    private Integer goodid;
    private Integer uid;



}
