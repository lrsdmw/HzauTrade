package com.ct.model;

import lombok.Data;

@Data
public class Account {
    //用户id
    private Integer userid;
    //用户名
    private String username;
    //用户密码
    private String password;
}
