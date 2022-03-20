package com.atmae.card.test.dao;

import com.atmae.card.domain.vo.CardVO;
import com.atmae.card.service.ICardService;
import com.atmae.card.service.impl.CardServiceImpl;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 20:11
 * @Description:
 */
public class LikedQueryTest {
    public static void main(String[] args) {
        ICardService cardService=new CardServiceImpl();
        List<CardVO> cards = cardService.queryCardsLiked(1L, "张");
        System.out.println(cards);
    }
}
