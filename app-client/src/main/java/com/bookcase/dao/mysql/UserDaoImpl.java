package com.bookcase.dao.mysql;

import com.bookcase.dao.DaoException;
import com.bookcase.dao.UserDao;
import com.bookcase.vo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
  Connection con;

  public UserDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(User user) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }

  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<User> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery();
      List<User> list = new ArrayList<>();

      while (rs.next()) {
        User user = new User();
        user.setNo(rs.getInt());
        user.setEmail(rs.getString());
        user.setName(rs.getString());
        user.setNick(rs.getString());
        user.setCreatedDate(rs.getDate());
        list.add(user);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public User findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        User user = new User();
        user.setNo(rs.getInt());
        user.setEmail(rs.getString());
        user.setName(rs.getString());
        user.setCreatedDate(rs.getDate());
        return user;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int update(User user) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
