package com.lvmeng.taolemall.controller;

import com.lvmeng.taolemall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@RestController
public class UsersController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public ModelAndView login(String username , String password){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("user",userService.login(username, password));
        return mav;

    }
}
