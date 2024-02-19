package com.bookcase.dao.mysql;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.dao.DaoException;
import com.bookcase.vo.BookCase;

import com.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookCaseDaoImpl implements BookCaseDao{

  DBConnectionPool connectionPool;

  public BookCaseDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(BookCase bookCase) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "insert into bookcases(case_title) values(?)")) {

      pstmt.setString(1, bookCase.getCaseTitle());
      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "delete from bookcases where bookcase_no=?")) {

      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<BookCase> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select * from bookcases order by bookcase_no desc");
        ResultSet rs = pstmt.executeQuery()) {

      List<BookCase> list = new ArrayList<>();

      while (rs.next()) {
        BookCase bookCase = new BookCase();
        bookCase.setNo(rs.getInt("bookcase_no"));
        bookCase.setCaseTitle(rs.getString("case_title"));
        bookCase.setBookmark(rs.getBoolean("bookmark"));
        bookCase.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());

        list.add(bookCase);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public BookCase findBy(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select * from bookcases where bookcase_no=?")) {

      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          BookCase bookCase = new BookCase();
          bookCase.setNo(rs.getInt("bookcase_no"));
          bookCase.setCaseTitle(rs.getString("case_title"));
          bookCase.setBookmark(rs.getBoolean("bookmark"));
          bookCase.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());

          return bookCase;
        }
        return null;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int update(BookCase bookCase) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "update bookcases set case_title=? where bookcase_no=?")) {

      pstmt.setString(1, bookCase.getCaseTitle());
      pstmt.setInt(2, bookCase.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int updateBookmark(BookCase bookCase) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "update bookcases set bookmark=? where bookcase_no=?")) {

      pstmt.setBoolean(1, bookCase.isBookmark());
      pstmt.setInt(2, bookCase.getNo());

      return pstmt.executeUpdate();
    } catch (Exception e) {

      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
