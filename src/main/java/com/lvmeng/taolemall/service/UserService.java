package com.lvmeng.taolemall.service;

import com.lvmeng.taolemall.Users;
import com.lvmeng.taolemall.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UsersMapper usersMapper;
    public Users login(String username , String password){
        return  usersMapper.login(username, password);
    }


    public int register(String username, String password, String user_address){
        return usersMapper.register(username, password, user_address);
    }

    public Users findUserByName(String username){
        return usersMapper.findUserByName(username);
    }

    public Users getInfoById(int user_id){
        return  usersMapper.getInfoById(user_id);
    }

}
