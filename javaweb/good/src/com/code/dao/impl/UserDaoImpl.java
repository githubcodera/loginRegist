package com.code.dao.impl;

import com.code.dao.UserDao;
import com.code.pojo.User;

/**
 * @author shhy
 * @create 2020-04-21 9:51
 **/
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from g_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into g_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`email` from g_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }
}
