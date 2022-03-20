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
import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/19
 * @Time: 13:18
 * @Description:
 */
@WebServlet(name = "ListUserServlet", urlPatterns = "/ListUserServlet")
public class ListUserServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.listUser();
        req.setAttribute("users", users);
        req.getRequestDispatcher("info.jsp").forward(req, resp);
    }
}
