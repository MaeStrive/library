package com.atmae.card.test.dao;

import com.atmae.card.dao.ICardDao;
import com.atmae.card.dao.impl.CardDaoImpl;
import com.atmae.card.domain.bean.Card;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 20:44
 * @Description:
 */
public class ListAllUser {
    public static void main(String[] args) {
        ICardDao cardDao=new CardDaoImpl();
        List<Card> cards = cardDao.listCardsAdmin();
        System.out.println(cards);
    }
}
