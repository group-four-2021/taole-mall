package com.lvmeng.taolemall;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Users {
    private int user_id;
    private String username;
    private String password;
    private String user_address;

}
