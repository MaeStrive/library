package com.atmae.card.servlet.card;

import com.atmae.card.domain.vo.CardVO;
import com.atmae.card.service.ICardService;
import com.atmae.card.service.impl.CardServiceImpl;

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
 * @Time: 12:34
 * @Description:
 */
@WebServlet(name = "ListCardAdminServlet", urlPatterns = "/ListCardAdminServlet")
public class ListCardAdminServlet extends HttpServlet {

    private ICardService cardService = new CardServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("test/html;charset=UTF-8");
        List<CardVO> cardVOS = cardService.listCardsAdmin();
        if (!cardVOS.isEmpty()) {
            req.setAttribute("cards", cardVOS);
            req.getRequestDispatcher("manage.jsp").forward(req, resp);
        }
    }
}
