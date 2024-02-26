package com.bookcase.dao.mysql;

import com.bookcase.dao.DaoException;
import com.bookcase.dao.UserDao;
import com.bookcase.vo.User;

import com.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

  DBConnectionPool connectionPool;

  public UserDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(User user) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "insert into users(email, name, nick, password) values(?,?,?,sha2(?, 256))")) {

      pstmt.setString(1, user.getEmail());
      pstmt.setString(2, user.getName());
      pstmt.setString(3, user.getNick());
      pstmt.setString(4, user.getPassword());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }

  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement("delete from users where user_no=?")) {
      pstmt.setInt(1, no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<User> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from users");
        ResultSet rs = pstmt.executeQuery()) {

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
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from users where user_no=?")) {
      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
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
      }

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public User findByEmailAndPassword(String email, String password) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select member_no, email, name, created_date from members"
            + " where email=? and password=sha2(?,256)")) {
      pstmt.setString(1, email);
      pstmt.setString(2, password);

      try (ResultSet rs = pstmt.executeQuery()) {
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
      }

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int update(User user) {
    String sql = null;
    if (user.getPassword().isEmpty()) {
      sql = "update members set email=?, name=? where member_no=?";
    } else {
      sql = "update members set email=?, name=?, password=sha2(?,256) where member_no=?";
    }

    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {

      pstmt.setString(1, user.getEmail());
      pstmt.setString(2, user.getName());
      pstmt.setString(3, user.getNick());
      pstmt.setString(4, user.getPassword());
      pstmt.setInt(5, user.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
