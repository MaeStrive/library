package com.atmae.card.service.impl;

import com.atmae.card.dao.IUserDao;
import com.atmae.card.dao.impl.CardDaoImpl;
import com.atmae.card.dao.impl.UserDaoImpl;
import com.atmae.card.domain.bean.Card;
import com.atmae.card.dao.ICardDao;
import com.atmae.card.domain.bean.User;
import com.atmae.card.domain.vo.CardVO;
import com.atmae.card.service.ICardService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 18:37
 * @Description:
 */
public class CardServiceImpl implements ICardService {

    private ICardDao cardDao = new CardDaoImpl();
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public void insertOrUpdateCard(Card card, Long userId) {
        //id为空为插入
        if (card.getId() == null) {
            cardDao.insertCard(card, userId);
        } else {
            //id不为空为更新
            cardDao.updateCard(card, userId);
        }
    }

    @Override
    public void deleteCardToWaste(Long id) {
        cardDao.deleteCardToWaste(id);
    }

    @Override
    public void deleteCardForever(Long id) {
        cardDao.deleteCardForever(id);
    }

    @Override
    public void recoverCard(Long id) {
        cardDao.updateCardByDel(id);
    }

    @Override
    public List<CardVO> queryCards(Long userId) {
        //查询当前用户的所有未删除名片
        List<Card> cards = cardDao.queryCards(userId);
        //根据用户id查询用户名
        User user = userDao.queryById(userId);
        if (cards.isEmpty()) {
            return null;
        } else {
            List<CardVO> cardVOS = new ArrayList<>();
            //转换成VO对象 返回前端
            for (Card card : cards) {
                CardVO cardVO = new CardVO(card.getId(), card.getName(), card.getGender(), card.getAccount()
                        , card.getPassword(), card.getEmail(), user.getName());
                cardVOS.add(cardVO);
            }
            return cardVOS;
        }
    }

    @Override
    public List<CardVO> queryCardsByWaste(Long userId) {
        //查询当前用户的所有回收站名片
        List<Card> cards = cardDao.queryCardsByWaste(userId);
        //根据用户id查询用户名
        User user = userDao.queryById(userId);
        if (cards.isEmpty()) {
            return null;
        } else {
            List<CardVO> cardVOS = new ArrayList<>();
            //转换成VO对象 返回前端
            for (Card card : cards) {
                CardVO cardVO = new CardVO(card.getId(), card.getName(), card.getGender(), card.getAccount()
                        , card.getPassword(), card.getEmail(), user.getName());
                cardVOS.add(cardVO);
            }
            return cardVOS;
        }
    }

    @Override
    public List<CardVO> queryCardsLiked(Long userId, String likedName) {
        //查询当前用户的所有回收站名片
        List<Card> cards = cardDao.queryCardsByNameLiked(userId, likedName);
        //根据用户id查询用户名
        User user = userDao.queryById(userId);
        if (cards.isEmpty()) {
            return null;
        } else {
            List<CardVO> cardVOS = new ArrayList<>();
            //转换成VO对象 返回前端
            for (Card card : cards) {
                CardVO cardVO = new CardVO(card.getId(), card.getName(), card.getGender(), card.getAccount()
                        , card.getPassword(), card.getEmail(), user.getName());
                cardVOS.add(cardVO);
            }
            return cardVOS;
        }
    }

    @Override
    public List<CardVO> queryCardsLikedByWaste(Long userId, String likedName) {
        //查询当前用户的所有回收站名片
        List<Card> cards = cardDao.queryCardsByNameLikedByWaste(userId, likedName);
        //根据用户id查询用户名
        User user = userDao.queryById(userId);
        if (cards.isEmpty()) {
            return null;
        } else {
            List<CardVO> cardVOS = new ArrayList<>();
            //转换成VO对象 返回前端
            for (Card card : cards) {
                CardVO cardVO = new CardVO(card.getId(), card.getName(), card.getGender(), card.getAccount()
                        , card.getPassword(), card.getEmail(), user.getName());
                cardVOS.add(cardVO);
            }
            return cardVOS;
        }
    }

    @Override
    public List<CardVO> listCardsAdmin() {
        //查询所有用户名片
        List<Card> cards = cardDao.listCardsAdmin();
        if (cards.isEmpty()) {
            return null;
        } else {
            List<CardVO> cardVOS = new ArrayList<>();
            for (Card card : cards) {
                //根据用户名片id查询姓名
                String name = userDao.queryById(card.getUserId()).getName();
                CardVO cardVO = new CardVO(card.getId(), card.getName(), card.getGender(), card.getAccount()
                        , card.getPassword(), card.getEmail(), name);
                cardVOS.add(cardVO);
            }
            return cardVOS;
        }
    }

    @Override
    public Card queryCardById(Long id) {
        return cardDao.getOneById(id);
    }

    @Override
    public List<CardVO> listCardsWasteAdmin() {
        List<Card> cards = cardDao.listCardsWasteAdmin();
        if (cards.isEmpty()) {
            return null;
        } else {
            List<CardVO> cardVOS = new ArrayList<>();
            for (Card card : cards) {
                //根据用户名片id查询姓名
                String name = userDao.queryById(card.getUserId()).getName();
                CardVO cardVO = new CardVO(card.getId(), card.getName(), card.getGender(), card.getAccount()
                        , card.getPassword(), card.getEmail(), name);
                cardVOS.add(cardVO);
            }
            return cardVOS;
        }
    }

    @Override
    public List<CardVO> listCardsAdminLiked(String likedName) {
        //查询当前用户的所有回收站名片
        List<Card> cards = cardDao.listCardsAdminLiked(likedName);
        if (cards.isEmpty()) {
            return null;
        } else {
            List<CardVO> cardVOS = new ArrayList<>();
            //转换成VO对象 返回前端
            for (Card card : cards) {
                //根据用户名片id查询姓名
                String name = userDao.queryById(card.getUserId()).getName();
                CardVO cardVO = new CardVO(card.getId(), card.getName(), card.getGender(), card.getAccount()
                        , card.getPassword(), card.getEmail(), name);
                cardVOS.add(cardVO);
            }
            return cardVOS;
        }
    }

    @Override
    public List<CardVO> listCardsWasteAdminLiked(String likedName) {
        //查询当前用户的所有回收站名片
        List<Card> cards = cardDao.listCardsWasteLiked(likedName);
        if (cards.isEmpty()) {
            return null;
        } else {
            List<CardVO> cardVOS = new ArrayList<>();
            //转换成VO对象 返回前端
            for (Card card : cards) {
                //根据用户名片id查询姓名
                String name = userDao.queryById(card.getUserId()).getName();
                CardVO cardVO = new CardVO(card.getId(), card.getName(), card.getGender(), card.getAccount()
                        , card.getPassword(), card.getEmail(), name);
                cardVOS.add(cardVO);
            }
            return cardVOS;
        }
    }
}
