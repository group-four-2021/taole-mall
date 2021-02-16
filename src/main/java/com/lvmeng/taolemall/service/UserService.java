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
}
