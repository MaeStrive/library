package com.atmae.card.test.dao;

import com.atmae.card.domain.bean.Card;
import com.atmae.card.service.ICardService;
import com.atmae.card.service.impl.CardServiceImpl;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 19:30
 * @Description:
 */
public class InsertCardTest {
    public static void main(String[] args) {
        ICardService cardService=new CardServiceImpl();
        Card card=new Card();
        card.setName("张三");
        card.setAccount("zhangsan333");
        card.setPassword("123456");
        card.setGender("男");
        card.setEmail("zhangsan@163.com");
        cardService.insertOrUpdateCard(card,1L);
    }
}
