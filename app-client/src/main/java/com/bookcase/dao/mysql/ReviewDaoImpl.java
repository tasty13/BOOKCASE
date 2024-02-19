package com.bookcase.dao.mysql;

import com.bookcase.dao.DaoException;
import com.bookcase.dao.ReviewDao;
import com.bookcase.vo.Review;

import com.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewDaoImpl implements ReviewDao {
  DBConnectionPool connectionPool;

  public ReviewDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(Review review) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "insert into reviews(book_title,score,comment) values(?,?,?)")) {

      pstmt.setString(1, review.getBookTitle());
      pstmt.setInt(2, review.getScore());
      pstmt.setString(3, review.getComment());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement("delete from reviews where review_no=?")) {

      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<Review> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select * from reviews order by review_no desc");
        ResultSet rs = pstmt.executeQuery()) {

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
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select * from reviews where review_no=?")) {
      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
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
      }

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int update(Review review) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "update reviews set score=?, comment=? where review_no=?")) {

      pstmt.setInt(1, review.getScore());
      pstmt.setString(2, review.getComment());
      pstmt.setInt(3, review.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {

      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
