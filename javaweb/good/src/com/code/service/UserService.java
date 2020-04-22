package com.code.service;

import com.code.pojo.User;

/**
 * @author shhy
 * @create 2020-04-21 14:29
 **/
public interface UserService {
    /*
    * 1.登录业务
    * 2.注册业务
    * 3.名称是否可用业务
    */
    public User login(User user);
    public void registUser(User user);
    public boolean exitsUsername(String username);
}
