package com.code.test;

import com.code.dao.UserDao;
import com.code.dao.impl.UserDaoImpl;
import com.code.pojo.User;
import org.junit.Test;

/**
 * @author shhy
 * @create 2020-04-21 13:59
 **/
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在！");
        }
    }
    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登录失败！");
        }else{
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"d","123456","123456@qq.com")));
    }
}