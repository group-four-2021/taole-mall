package com.lvmeng.taolemall.mapper;

import com.lvmeng.taolemall.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    Users login(String username,String password);
}
