package com.atmae.card.servlet.card;

import com.atmae.card.service.ICardService;
import com.atmae.card.service.impl.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mae
 * @Date: 2022/3/19
 * @Time: 11:08
 * @Description:
 */
@WebServlet(name = "DeleteForeverCardServlet", urlPatterns = "/DeleteForeverCardServlet")
public class DeleteForeverCardServlet extends HttpServlet {
    private ICardService cardService = new CardServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("id");
        cardService.deleteCardForever(Long.valueOf(id));
        req.getRequestDispatcher("waste.jsp").forward(req, resp);
    }
}
