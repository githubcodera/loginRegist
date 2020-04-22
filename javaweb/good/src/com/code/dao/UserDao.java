package com.code.dao;

import com.code.pojo.User;

/**
 * @author shhy
 * @create 2020-04-21 9:43
 **/
public interface UserDao {

    /* 1.根据用户名查询用户信息。*/
    public User queryUserByUsername(String username);
    /* 2.根据用户名和密码查询用户 */
    public User queryUserByUsernameAndPassword(String username,String password);
    /* 3.保存用户信息 */
    public int saveUser(User user);
}
