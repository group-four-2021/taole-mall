package com.lvmeng.taolemall.controller;

import com.lvmeng.taolemall.service.CommoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 商品控制类
 * author : 成佳骏
 */
@RestController
public class CommoController {

    @Autowired
    CommoService commoService;

    @RequestMapping(value = "/showCommo")
    public ModelAndView showCommo(int commo_id) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("commo",commoService.showCommo(commo_id));
        return mav;
    }

    @RequestMapping(value = "/getAllCommo")
    public ModelAndView getAllCommo(){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("commo",commoService.getAllCommo());
        return mav;
    }

}
