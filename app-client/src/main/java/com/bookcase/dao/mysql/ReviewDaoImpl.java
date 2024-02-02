package com.bookcase.dao.mysql;

import com.bookcase.dao.DaoException;
import com.bookcase.dao.ReviewDao;
import com.bookcase.vo.Review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewDaoImpl implements ReviewDao {
  Connection con;

  public ReviewDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Review review) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into reviews(book_title,score,comment) values('%s',%d,'%s')",
          review.getBookTitle(), review.getScore(), review.getComment()
      ));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from reviews where review_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<Review> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from reviews");
      List<Review> list = new ArrayList<>();

      while (rs.next()) {
        Review review = new Review();
        review.setNo(rs.getInt("review_no"));
        review.setBookTitle(rs.getString("book_title"));
        review.setScore(rs.getInt("score"));
        review.setComment(rs.getString("comment"));
        review.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        list.add(review);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public Review findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
          String.format("select * from reviews where review_no=%d", no));

      if (rs.next()) {
        Review review = new Review();
        review.setNo(rs.getInt("review_no"));
        review.setBookTitle(rs.getString("book_title"));
        review.setScore(rs.getInt("score"));
        review.setComment(rs.getString("comment"));
        review.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        return review;
      }
      return null;
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int update(Review review) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update reviews set score=%d, comment='%s' where review_no=%d",
          review.getScore(), review.getComment(), review.getNo()
      ));
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
