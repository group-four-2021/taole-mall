package com.lvmeng.taolemall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.lvmeng.taolemall.Commo;
import com.lvmeng.taolemall.Order;
import com.lvmeng.taolemall.service.OrderService;
import com.lvmeng.taolemall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserId",method = RequestMethod.POST)
    public ModelAndView viewUserOrder(int user_id){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("order",orderService.viewUserOrder(user_id));
        return mav;
    }


    @RequestMapping(value = "/addNewOrder",method = RequestMethod.POST)
    public ModelAndView addNewOrder(int user_id, @RequestParam("commo_id[]") ArrayList<Integer> commo_id){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        //mav.addObject("commo_id",commo_id);
        int menu_id;
        if(orderService.updateMenu() == null){
            menu_id = 1;
        }else {
            Order temp = orderService.updateMenu();
            menu_id = temp.getMenu_id() + 1;
        }
        //mav.addObject("menu_id",menu_id);
        orderService.addNewOrder(user_id,menu_id,0);
        int flag = 0;
        try{
            for(int i=0;i<commo_id.size();i++) {
                flag = orderService.addCommoToMetoTable(commo_id.get(i), menu_id);
            }
            //mav.addObject("flag",flag);
        }catch (Exception e){
            flag = 0;
        }
        if (flag == 0){
            mav.addObject("status","something wrong with your order1...");
            return mav;
        }
        float count = 0;
        for(int i=0;i<commo_id.size();i++) {
            int commo = commo_id.get(i);
            Commo temp1 = orderService.sumUp(commo);
            if(temp1 == null){
                count = 0;
                break;
            }else{

                count = count + temp1.getCommo_cost();
            }
        }
        mav.addObject("total_cost",count);
        int flag1;
        try{
            flag1 = orderService.updateOrder(count,menu_id);
        }catch (Exception e){
            flag1 = 0;
        }
        if (flag1 == 0){
            mav.addObject("status","something wrong with your order2...");
            return mav;
        }
        mav.addObject("status","order adding succeeded!");
        return mav;
    }

    @RequestMapping(value = "/deleteOrder",method = RequestMethod.POST)
    public ModelAndView deleteOrder(int menu_id){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        int flag;
        flag = orderService.deleteOrder(menu_id);
        if(flag != 0) {
            mav.addObject("status", "delete order succeeded!");
        }else{
            mav.addObject("status", "delete order failed!");
        }
        return mav;
    }








}
