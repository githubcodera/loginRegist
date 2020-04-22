package com.code.service.impl;

import com.code.dao.UserDao;
import com.code.dao.impl.UserDaoImpl;
import com.code.pojo.User;
import com.code.service.UserService;

/**
 * @author shhy
 * @create 2020-04-21 14:31
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean exitsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;

    }
}
