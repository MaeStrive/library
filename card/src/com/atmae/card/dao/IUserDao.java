package com.atmae.card.dao;

import com.atmae.card.domain.bean.User;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 16:18
 * @Description:
 */
public interface IUserDao {

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询
     *
     * @param username
     * @param password
     * @return
     */
    User queryByUsernameAndPassword(String username, String password);

    /**
     * 插入用户信息
     * @param user
     */
    void insertUser(User user);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User queryById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> listUser();

    /**
     * 删除用户
     * @param id
     * @return
     */
    Boolean deleteUser(Long id);

}
