package com.lvmeng.taolemall.service;

import com.lvmeng.taolemall.Order;
import com.lvmeng.taolemall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    public Order viewUserOrder(int user_id){
        return orderMapper.viewUserOrder(user_id);
    }
    public Order addNewOrder(int user_id){
        return orderMapper.addNewOrder(user_id);
    }
}
