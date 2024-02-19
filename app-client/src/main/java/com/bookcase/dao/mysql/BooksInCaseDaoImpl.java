package com.bookcase.dao.mysql;

import com.bookcase.dao.BooksInCaseDao;
import com.bookcase.dao.DaoException;
import com.bookcase.vo.BooksInCase;
import com.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BooksInCaseDaoImpl implements BooksInCaseDao {

  DBConnectionPool connectionPool;

  public BooksInCaseDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(BooksInCase booksInCase) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "insert into books_in_case(book_title, bookcase_no) values(?,?)")) {

      pstmt.setString(1, booksInCase.getBookTitle());
      pstmt.setInt(2, booksInCase.getBookCaseNo());

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
  public List<BooksInCase> findAllByCaseNo(int caseNo) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select * from books_in_case where bookcase_no=?")) {

      pstmt.setInt(1, caseNo);
      try (ResultSet rs = pstmt.executeQuery()) {
        List<BooksInCase> list = new ArrayList<>();

        while (rs.next()) {
          BooksInCase booksInCase = new BooksInCase();
          booksInCase.setNo(rs.getInt("books_in_case_no"));
          booksInCase.setBookTitle(rs.getString("book_title"));
          list.add(booksInCase);
        }
        return list;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
