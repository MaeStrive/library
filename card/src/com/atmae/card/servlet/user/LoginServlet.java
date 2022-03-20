package com.atmae.card.servlet.user;

import com.atmae.card.domain.bean.User;
import com.atmae.card.service.IUserService;
import com.atmae.card.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 11:16
 * @Description:
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理登录请求
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        if (user!=null){
            //登录成功
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else{
            //登陆失败
            req.setAttribute("msg","用户名或者密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
