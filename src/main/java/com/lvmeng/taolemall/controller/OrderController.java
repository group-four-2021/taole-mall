package com.lvmeng.taolemall.controller;

import com.lvmeng.taolemall.Order;
import com.lvmeng.taolemall.service.OrderService;
import com.lvmeng.taolemall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/{user_id}")
    public ModelAndView viewUserOrder(int user_id){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("order",orderService.viewUserOrder(user_id));
        return mav;
    }

    // TODO: 21/02/19
    @RequestMapping(value = "/addNewOrder")
    public ModelAndView addNewOrder(int user_id){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        return mav;
    }





}
