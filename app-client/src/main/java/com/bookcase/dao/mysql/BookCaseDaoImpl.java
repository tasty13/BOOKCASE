package com.bookcase.dao.mysql;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.dao.DaoException;
import com.bookcase.vo.BookCase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookCaseDaoImpl implements BookCaseDao{
  Connection con;

  public BookCaseDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(BookCase bookCase) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into bookcases(case_title) values('%s')", bookCase.getCaseTitle()
      ));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from bookcases where bookcase_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<BookCase> findAllByCaseNo() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from bookcases");
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
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
          String.format("select * from bookcases where bookcase_no=%d", no));

      if (rs.next()) {
        BookCase bookCase = new BookCase();
        bookCase.setNo(rs.getInt("bookcase_no"));
        bookCase.setCaseTitle(rs.getString("case_title"));
        bookCase.setBookmark(rs.getBoolean("bookmark"));
        bookCase.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        return bookCase;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int update(BookCase bookCase) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update bookcases set case_title='%s' where bookcase_no=%d"
          , bookCase.getCaseTitle(), bookCase.getNo()
      ));
    } catch (Exception e) {

      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int updateBookmark(BookCase bookCase) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update bookcases set bookmark=%b where bookcase_no=%d"
          , bookCase.isBookmark(), bookCase.getNo()
      ));
    } catch (Exception e) {

      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
