package com.atmae.card.dao;

import com.atmae.card.domain.bean.Card;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 18:37
 * @Description:
 */
public interface ICardDao {
    /**
     * 插入
     * @param card
     */
    void insertCard(Card card,Long userId);

    /**
     * 更新
     * @param card
     */
    void updateCard(Card card,Long userId);

    /**
     * 删除到回收站
     * @param id
     */
    void deleteCardToWaste(Long id);

    /**
     * 永久删除
     * @param id
     */
    void deleteCardForever(Long id);

    /**
     * 回收站恢复
     * @param id
     */
    void updateCardByDel(Long id);

    /**
     * 根据用户id查询当前用户的所有名片
     * @param userId
     * @return
     */
    List<Card> queryCards(Long userId);

    /**
     * 根据用户id查询当前用户所有回收站名片
     * @param userId
     * @return
     */
    List<Card> queryCardsByWaste(Long userId);

    /**
     * 模糊查询
     * @param name
     * @param userId
     * @return
     */
    List<Card> queryCardsByNameLiked(Long userId,String name);

    /**
     * 模糊查询回收站
     * @param userId
     * @param likedName
     * @return
     */
    List<Card> queryCardsByNameLikedByWaste(Long userId, String likedName);

    /**
     * 根据用户id删除所有名片(回收站)
     * @param userId
     * @return
     */
    Boolean deleteCardByUserId(Long userId);

    /**
     * 查询所有用户名片
     * @return
     */
    List<Card> listCardsAdmin();

    /**
     * 根据id查询名片
     * @param id
     * @return
     */
    Card getOneById(Long id);

    /**
     * 管理员操作 查询所有回收站名片
     * @return
     */
    List<Card> listCardsWasteAdmin();

    /**
     * 管理员操作 模糊查询所有名片
     * @param likedName
     * @return
     */
    List<Card> listCardsAdminLiked(String likedName);

    /**
     * 管理员操作 模糊查询所有回收站名片
     * @param likedName
     * @return
     */
    List<Card> listCardsWasteLiked(String likedName);
}
