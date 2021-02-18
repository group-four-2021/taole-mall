package com.lvmeng.taolemall;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 商品类
 * author : 成佳骏
 */
@Setter
@Getter
@ToString
public class Commo {

    private int commo_id;
    private String commo_name;
    private String commo_brief;
    private float commo_cost;
    private int commo_type;
}
