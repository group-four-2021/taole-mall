package com.lvmeng.taolemall.mapper;

import com.lvmeng.taolemall.Commo;
import com.lvmeng.taolemall.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderMapper {
    Order viewUserOrder(int user_id);
    int addNewOrder(int user_id,int menu_id,int count);
    int addCommoToMetoTable(int commo_id,int menu_id);
    Commo sumUp(int commo_id);
    int updateOrder(float count,int menu_id);
    Order updateMenu();
    int deleteOrder(int menu_id);

}
