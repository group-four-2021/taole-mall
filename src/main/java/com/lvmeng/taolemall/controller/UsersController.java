package com.lvmeng.taolemall.controller;

import com.lvmeng.taolemall.Users;
import com.lvmeng.taolemall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/getInfoById")
    public ModelAndView getInfoById(int user_id){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("info",userService.getInfoById(user_id));
        return mav;
    }


    @RequestMapping(value = "/register")
    public ModelAndView register(String username, String password, String user_address){
        Users userByName = userService.findUserByName(username);
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        if(userByName != null){
            mav.addObject("flag", false);
            mav.addObject("user", "用户名重复");
            return mav;
        }
        //count返回1为插入数据成功，0为失败
        int count;
        try{
            count = userService.register(username, password, user_address);
        }catch (Exception e){
            count = 0;
        }
        if(count == 1){
            mav.addObject("flag", true);
            mav.addObject("user", userService.login(username, password));
        }else{
            mav.addObject("flag", false);
        }
        return mav;

    }


}
