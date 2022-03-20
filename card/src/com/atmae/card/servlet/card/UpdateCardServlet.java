package com.atmae.card.servlet.card;

import com.atmae.card.domain.bean.Card;
import com.atmae.card.domain.bean.User;
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
 * @Time: 13:10
 * @Description:
 */
@WebServlet(name = "UpdateCardServlet", urlPatterns = "/UpdateCardServlet")
public class UpdateCardServlet extends HttpServlet {
    private ICardService cardService = new CardServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        Card card = new Card();
        Long id = Long.valueOf(req.getParameter("id"));
        card.setId(id);
        String account = req.getParameter("account");
        card.setAccount(account);
        String email = req.getParameter("email");
        card.setEmail(email);
        String password = req.getParameter("password");
        card.setPassword(password);
        String name = req.getParameter("name");
        name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        card.setName(name);
        String gender = req.getParameter("gender");
        gender = new String(gender.getBytes("ISO-8859-1"), "UTF-8");
        card.setGender(gender);
        cardService.insertOrUpdateCard(card, user.getId());
        req.getRequestDispatcher("insert.jsp").forward(req, resp);
    }
}
