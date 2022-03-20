package com.atmae.card.service;

import com.atmae.card.domain.bean.Card;
import com.atmae.card.domain.vo.CardVO;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 18:23
 * @Description:
 */
public interface ICardService {

    /**
     * 增加/更新名片
     *
     * @param userId
     * @param card
     */
    void insertOrUpdateCard(Card card, Long userId);

    /**
     * 删除到回收站
     *
     * @param id
     */
    void deleteCardToWaste(Long id);

    /**
     * 永久删除
     *
     * @param id
     */
    void deleteCardForever(Long id);

    /**
     * 恢复删除名片
     *
     * @param id
     */
    void recoverCard(Long id);

    /**
     * 查询该用户所有未删除名片
     *
     * @param userId
     * @return
     */
    List<CardVO> queryCards(Long userId);

    /**
     * 查询当前用户所有回收站名片
     *
     * @param userId
     * @return
     */
    List<CardVO> queryCardsByWaste(Long userId);

    /**
     * 根据姓名模糊查询
     *
     * @param userId
     * @param likedName
     * @return
     */
    List<CardVO> queryCardsLiked(Long userId, String likedName);

    /**
     * 根据id查询当前名片
     *
     * @param id
     * @return
     */
    Card queryCardById(Long id);

    /**
     * 根据姓名模糊查询回收站
     *
     * @param userId
     * @param likedName
     * @return
     */
    List<CardVO> queryCardsLikedByWaste(Long userId, String likedName);

    /**
     * 查询所有用户名片 管理员操作
     *
     * @return
     */
    List<CardVO> listCardsAdmin();

    /**
     * 查询所有回收站的名片 管理员操作
     *
     * @return
     */
    List<CardVO> listCardsWasteAdmin();

    /**
     * 模糊查询所有名片
     *
     * @param likedName
     * @return
     */
    List<CardVO> listCardsAdminLiked(String likedName);

    /**
     * 模糊查询所有回收站名片
     *
     * @param likedName
     * @return
     */
    List<CardVO> listCardsWasteAdminLiked(String likedName);
}
