package com.atmae.card.dao.impl;

import com.atmae.card.constants.SystemConstants;
import com.atmae.card.dao.ICardDao;
import com.atmae.card.dao.IUserDao;
import com.atmae.card.domain.bean.User;
import com.atmae.card.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 16:18
 * @Description:
 */
public class UserDaoImpl implements IUserDao {

    private ICardDao cardDao = new CardDaoImpl();

    @Override
    public User queryUserByUsername(String username) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        String sql = "select * from sys_user where username=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                user.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return user;
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        //根据用户名查询用户
        User user = queryUserByUsername(username);
        if (user == null) {
            return null;
        }
        //比对密码是否相等
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void insertUser(User user) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into sys_user(username,password,name) values (?,?,?)";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
    }

    @Override
    public User queryById(Long id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        String sql = "select * from sys_user where id=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return user;
    }

    @Override
    public List<User> listUser() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> users = null;
        User user = null;
        String sql = "select * from sys_user where role=? and del_field=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, SystemConstants.NORMAL);
            preparedStatement.setInt(2, SystemConstants.NO_DEL);
            resultSet = preparedStatement.executeQuery();
            users = new ArrayList<>();
            while (resultSet.next()) {
                user = new User();
                user.setPassword(resultSet.getString("password"));
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setRole(resultSet.getString("role"));
                user.setName(resultSet.getString("name"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return users;
    }

    @Override
    public Boolean deleteUser(Long id) {
        //删除用户 名片也会被删除
        cardDao.deleteCardByUserId(id);
        //删除用户
        PreparedStatement preparedStatement = null;
        String sql = "update sys_user set del_field=? where id=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, SystemConstants.ALR_DEL);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return true;
    }
}
