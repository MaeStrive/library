package com.atmae.card.test.service;

import com.atmae.card.domain.bean.User;
import com.atmae.card.service.IUserService;
import com.atmae.card.service.impl.UserServiceImpl;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 17:20
 * @Description:
 */
public class RegisterTest {
    public static void main(String[] args) {
        IUserService userService = new UserServiceImpl();
        User user = new User();
        user.setUsername("mae");
        user.setPassword("666666");
        user.setName("王浩");
        userService.register(user);
    }
}
