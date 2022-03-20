package com.atmae.card.dao.impl;

import com.atmae.card.constants.SystemConstants;
import com.atmae.card.dao.ICardDao;
import com.atmae.card.domain.bean.Card;
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
 * @Time: 18:37
 * @Description:
 */
public class CardDaoImpl implements ICardDao {

    @Override
    public void insertCard(Card card, Long userId) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into card_user(name,gender,account,password,email,user_id) values (?,?,?,?,?,?)";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, card.getName());
            preparedStatement.setString(2, card.getGender());
            preparedStatement.setString(3, card.getAccount());
            preparedStatement.setString(4, card.getPassword());
            preparedStatement.setString(5, card.getEmail());
            preparedStatement.setLong(6, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
    }

    @Override
    public void updateCard(Card card, Long userId) {
        PreparedStatement preparedStatement = null;
        String sql = "update card_user set name =?,gender =?,account=?,password=?,email=? where id=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, card.getName());
            preparedStatement.setString(2, card.getGender());
            preparedStatement.setString(3, card.getAccount());
            preparedStatement.setString(4, card.getPassword());
            preparedStatement.setString(5, card.getEmail());
            preparedStatement.setLong(6, card.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
    }

    @Override
    public void deleteCardToWaste(Long id) {
        PreparedStatement preparedStatement = null;
        String sql = "update card_user set del_field=?  where id=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, SystemConstants.WASTER);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
    }

    @Override
    public void deleteCardForever(Long id) {
        PreparedStatement preparedStatement = null;
        String sql = "update card_user set del_field=? where id=?";
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
    }

    @Override
    public void updateCardByDel(Long id) {
        PreparedStatement preparedStatement = null;
        String sql = "update card_user set del_field=? where id=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, SystemConstants.NO_DEL);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
    }

    @Override
    public List<Card> queryCards(Long userId) {
        PreparedStatement preparedStatement = null;
        List<Card> cards = null;
        String sql = "select * from card_user where user_id=? and del_field=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            preparedStatement.setInt(2, SystemConstants.NO_DEL);
            ResultSet resultSet = preparedStatement.executeQuery();
            cards = new ArrayList<>();
            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getLong("id"));
                card.setAccount(resultSet.getString("account"));
                card.setPassword(resultSet.getString("password"));
                card.setName(resultSet.getString("name"));
                card.setGender(resultSet.getString("gender"));
                card.setEmail(resultSet.getString("email"));
                card.setUserId(resultSet.getLong("user_id"));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return cards;
    }

    @Override
    public List<Card> queryCardsByWaste(Long userId) {
        PreparedStatement preparedStatement = null;
        List<Card> cards = null;
        String sql = "select * from card_user where user_id=? and del_field=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            preparedStatement.setInt(2, SystemConstants.WASTER);
            ResultSet resultSet = preparedStatement.executeQuery();
            cards = new ArrayList<>();
            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getLong("id"));
                card.setAccount(resultSet.getString("account"));
                card.setPassword(resultSet.getString("password"));
                card.setName(resultSet.getString("name"));
                card.setGender(resultSet.getString("gender"));
                card.setEmail(resultSet.getString("email"));
                card.setUserId(resultSet.getLong("user_id"));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return cards;
    }

    @Override
    public List<Card> queryCardsByNameLiked(Long userId, String likedName) {
        PreparedStatement preparedStatement = null;
        List<Card> cards = null;
        String sql = "select * from card_user where user_id=? and del_field=? and name like ?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            preparedStatement.setInt(2, SystemConstants.NO_DEL);
            preparedStatement.setString(3, "%" + likedName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            cards = new ArrayList<>();
            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getLong("id"));
                card.setAccount(resultSet.getString("account"));
                card.setPassword(resultSet.getString("password"));
                card.setName(resultSet.getString("name"));
                card.setGender(resultSet.getString("gender"));
                card.setEmail(resultSet.getString("email"));
                card.setUserId(resultSet.getLong("user_id"));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return cards;
    }

    @Override
    public List<Card> queryCardsByNameLikedByWaste(Long userId, String likedName) {
        PreparedStatement preparedStatement = null;
        List<Card> cards = null;
        String sql = "select * from card_user where user_id=? and del_field=? and name like ?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            preparedStatement.setInt(2, SystemConstants.WASTER);
            preparedStatement.setString(3, "%" + likedName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            cards = new ArrayList<>();
            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getLong("id"));
                card.setAccount(resultSet.getString("account"));
                card.setPassword(resultSet.getString("password"));
                card.setName(resultSet.getString("name"));
                card.setGender(resultSet.getString("gender"));
                card.setEmail(resultSet.getString("email"));
                card.setUserId(resultSet.getLong("user_id"));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return cards;
    }

    @Override
    public Boolean deleteCardByUserId(Long userId) {
        PreparedStatement preparedStatement = null;
        String sql = "update card_user set del_field=? where user_id=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, SystemConstants.ALR_DEL);
            preparedStatement.setLong(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return true;
    }

    @Override
    public List<Card> listCardsAdmin() {
        PreparedStatement preparedStatement = null;
        List<Card> cards = null;
        String sql = "select * from card_user where del_field=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, SystemConstants.NO_DEL);
            ResultSet resultSet = preparedStatement.executeQuery();
            cards = new ArrayList<>();
            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getLong("id"));
                card.setAccount(resultSet.getString("account"));
                card.setPassword(resultSet.getString("password"));
                card.setName(resultSet.getString("name"));
                card.setGender(resultSet.getString("gender"));
                card.setEmail(resultSet.getString("email"));
                card.setUserId(resultSet.getLong("user_id"));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    @Override
    public Card getOneById(Long id) {
        PreparedStatement preparedStatement = null;
        Card card = null;
        String sql = "select * from card_user where del_field=? and id=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, SystemConstants.NO_DEL);
            preparedStatement.setLong(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                card = new Card();
                card.setGender(resultSet.getString("gender"));
                card.setPassword(resultSet.getString("password"));
                card.setName(resultSet.getString("name"));
                card.setAccount(resultSet.getString("account"));
                card.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return card;
    }

    @Override
    public List<Card> listCardsWasteAdmin() {
        PreparedStatement preparedStatement = null;
        List<Card> cards = null;
        String sql = "select * from card_user where del_field=?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, SystemConstants.WASTER);
            ResultSet resultSet = preparedStatement.executeQuery();
            cards = new ArrayList<>();
            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getLong("id"));
                card.setAccount(resultSet.getString("account"));
                card.setPassword(resultSet.getString("password"));
                card.setName(resultSet.getString("name"));
                card.setGender(resultSet.getString("gender"));
                card.setEmail(resultSet.getString("email"));
                card.setUserId(resultSet.getLong("user_id"));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    @Override
    public List<Card> listCardsAdminLiked(String likedName) {
        PreparedStatement preparedStatement = null;
        List<Card> cards = null;
        String sql = "select * from card_user where del_field=? and name like ?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, SystemConstants.NO_DEL);
            preparedStatement.setString(2, "%" + likedName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            cards = new ArrayList<>();
            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getLong("id"));
                card.setAccount(resultSet.getString("account"));
                card.setPassword(resultSet.getString("password"));
                card.setName(resultSet.getString("name"));
                card.setGender(resultSet.getString("gender"));
                card.setEmail(resultSet.getString("email"));
                card.setUserId(resultSet.getLong("user_id"));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return cards;
    }

    @Override
    public List<Card> listCardsWasteLiked(String likedName) {
        PreparedStatement preparedStatement = null;
        List<Card> cards = null;
        String sql = "select * from card_user where del_field=? and name like ?";
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, SystemConstants.WASTER);
            preparedStatement.setString(2, "%" + likedName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            cards = new ArrayList<>();
            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getLong("id"));
                card.setAccount(resultSet.getString("account"));
                card.setPassword(resultSet.getString("password"));
                card.setName(resultSet.getString("name"));
                card.setGender(resultSet.getString("gender"));
                card.setEmail(resultSet.getString("email"));
                card.setUserId(resultSet.getLong("user_id"));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return cards;
    }
}
