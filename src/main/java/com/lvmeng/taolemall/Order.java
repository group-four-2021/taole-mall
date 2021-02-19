package com.lvmeng.taolemall;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Order {
    private int menu_id;
    private int menu_cost;
    private int user_id;
}
