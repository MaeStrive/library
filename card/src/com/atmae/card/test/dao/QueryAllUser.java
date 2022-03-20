package com.atmae.card.test.dao;

import com.atmae.card.domain.bean.User;
import com.atmae.card.service.IUserService;
import com.atmae.card.service.impl.UserServiceImpl;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 20:23
 * @Description:
 */
public class QueryAllUser {
    public static void main(String[] args) {
        IUserService userService=new UserServiceImpl();
        List<User> users = userService.listUser();
        System.out.println(users);
    }
}
