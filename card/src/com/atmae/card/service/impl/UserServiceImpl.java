package com.atmae.card.service.impl;

import com.atmae.card.domain.bean.User;
import com.atmae.card.dao.IUserDao;
import com.atmae.card.dao.impl.UserDaoImpl;
import com.atmae.card.service.IUserService;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 16:18
 * @Description:
 */
public class UserServiceImpl implements IUserService {

    private IUserDao userDao=new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        //查询用户名
        User user = userDao.queryUserByUsername(username);
        if (user == null) {
            return null;
        } else {
            //查询密码是否正确
            return userDao.queryByUsernameAndPassword(username, password);
        }
    }

    @Override
    public Boolean register(User user) {
        //查询用户名是否存在
        User u = userDao.queryUserByUsername(user.getUsername());
        if (u != null) {
            //用户名已存在
            return false;
        } else {
            //创建用户
            userDao.insertUser(user);
            return true;
        }
    }

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
