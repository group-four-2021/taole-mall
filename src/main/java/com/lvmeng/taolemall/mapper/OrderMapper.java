package com.lvmeng.taolemall.mapper;

import com.lvmeng.taolemall.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    Order viewUserOrder(int user_id);
    Order addNewOrder(int user_id);

}
