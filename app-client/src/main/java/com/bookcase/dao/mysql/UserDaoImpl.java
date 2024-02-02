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
      stmt.executeUpdate(String.format(
          "insert into users(email, name, nick, password) values('%s','%s','%s',sha2('%s', 256))",
          user.getEmail(), user.getName(), user.getNick(), user.getPassword()));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }

  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from users where user_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<User> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from users");
      List<User> list = new ArrayList<>();

      while (rs.next()) {
        User user = new User();
        user.setNo(rs.getInt("user_no"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        user.setNick(rs.getString("nick"));
        user.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
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
      ResultSet rs = stmt.executeQuery(String.format("select * from users where user_no=%d", no));

      if (rs.next()) {
        User user = new User();
        user.setNo(rs.getInt("user_no"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        user.setNick(rs.getString("nick"));
        user.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
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
      return stmt.executeUpdate(String.format(
          "update users set email='%s',name='%s',nick='%s',password=sha2('%s',256) where user_no=%d;",
          user.getEmail(), user.getName(), user.getNick(), user.getPassword(), user.getNo()
      ));
    } catch (Exception e) {

      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
