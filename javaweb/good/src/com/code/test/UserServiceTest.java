package com.code.test;

import com.code.pojo.User;
import com.code.service.UserService;
import com.code.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author shhy
 * @create 2020-04-21 14:45
 **/
public class UserServiceTest {
    private UserService userService = new UserServiceImpl();

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"b","123456","b@qq.com")));
    }

    @Test
    public void registUser() {
        userService.registUser(new User(null,"c","123456","c@qq.com"));
    }

    @Test
    public void exitsUsername() {
        if(userService.exitsUsername("c")){
            System.out.println("存在");
        }else{
            System.out.println("可以用");
        }
    }
}