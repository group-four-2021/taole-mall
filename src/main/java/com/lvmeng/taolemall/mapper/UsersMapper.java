package com.lvmeng.taolemall.mapper;

import com.lvmeng.taolemall.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    Users login(String username,String password);
    int register(String username, String password, String user_address);
    Users findUserByName(String username);
    Users getInfoById(int user_id);

}
