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
 * @Time: 20:47
 * @Description:
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
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
        String name = req.getParameter("name");
        name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        if (userService.register(user)) {
            //注册成功
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            //注册失败 重定向
            resp.sendRedirect("register.jsp");
        }
    }
}
