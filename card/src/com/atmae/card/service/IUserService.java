package com.atmae.card.service;

import com.atmae.card.domain.bean.User;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 16:18
 * @Description:
 */
public interface IUserService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    Boolean register(User user);

    /**
     * 查询所有用户 管理员操作
     * @return
     */
    List<User> listUser();

    /**
     * 根据id删除某个用户
     * @param id
     * @return
     */
    Boolean deleteUser(Long id);
}
