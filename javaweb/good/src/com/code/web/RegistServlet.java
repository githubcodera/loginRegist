package com.code.web;

import com.code.pojo.User;
import com.code.service.UserService;
import com.code.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shhy
 * @create 2020-04-21 15:12
 **/
public class RegistServlet extends HttpServlet {
    /*
    注册有密码，doPost
    1.获取请求的参数
    2.检查验证码是否正确
    3.检查用户名是否可用
       报错
       成功：返回到登录页面
    */
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email =  req.getParameter("email");
        String code =  req.getParameter("code");
        if("abcde".equalsIgnoreCase(code)){
            if(userService.exitsUsername(username)){
                System.out.println("用户名"+username+"已存在！");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            }else{
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);

            }
        }else{
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}






