package com.atmae.card.test.service;

import com.atmae.card.service.IUserService;
import com.atmae.card.service.impl.UserServiceImpl;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 18:18
 * @Description:
 */
public class LoginTest {
    public static void main(String[] args) {
        IUserService userService=new UserServiceImpl();
        System.out.println(userService.login("mae", "666666"));
    }
}
