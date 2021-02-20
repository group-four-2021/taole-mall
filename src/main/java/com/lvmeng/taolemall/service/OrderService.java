package com.lvmeng.taolemall.service;

import com.lvmeng.taolemall.Commo;
import com.lvmeng.taolemall.Order;
import com.lvmeng.taolemall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    public Order viewUserOrder(int user_id){
        return orderMapper.viewUserOrder(user_id);
    }
    public int addNewOrder(int user_id,int menu_id,int count){
        return orderMapper.addNewOrder(user_id,menu_id,count);
    }
    public int addCommoToMetoTable(int commo_id, int menu_id){
        return orderMapper.addCommoToMetoTable(commo_id, menu_id);
    }
    public Commo sumUp(int commo_id){
        try{
            return orderMapper.sumUp(commo_id);
        }catch (Exception e){
            return null;
        }

    }
    public Order updateMenu(){
        try{
            //System.out.println(orderMapper.updateMenu());
            return orderMapper.updateMenu();
        }catch (Exception e){
            return null;
        }

    }
    public int updateOrder(float count,int menu_id){

        return orderMapper.updateOrder(count,menu_id);
    }
    public int deleteOrder(int menu_id){
        return orderMapper.deleteOrder(menu_id);
    }
}
