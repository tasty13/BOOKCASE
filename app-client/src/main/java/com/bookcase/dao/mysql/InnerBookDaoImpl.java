package com.bookcase.dao.mysql;

import com.bookcase.dao.InnerBookDao;
import com.bookcase.dao.DaoException;
import com.bookcase.vo.InnerBook;
import com.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InnerBookDaoImpl implements InnerBookDao {

  DBConnectionPool connectionPool;

  public InnerBookDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(InnerBook innerBook) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "insert into books_in_case(book_title, bookcase_no) values(?,?)")) {

      pstmt.setString(1, innerBook.getBookTitle());
      pstmt.setInt(2, innerBook.getBookCaseNo());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "delete from books_in_case where books_in_case_no=?")) {

      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<InnerBook> findAllByCaseNo(int caseNo) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select * from books_in_case where bookcase_no=?")) {

      pstmt.setInt(1, caseNo);
      try (ResultSet rs = pstmt.executeQuery()) {
        List<InnerBook> list = new ArrayList<>();

        while (rs.next()) {
          InnerBook innerBook = new InnerBook();
          innerBook.setNo(rs.getInt("books_in_case_no"));
          innerBook.setBookTitle(rs.getString("book_title"));
          list.add(innerBook);
        }
        return list;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
