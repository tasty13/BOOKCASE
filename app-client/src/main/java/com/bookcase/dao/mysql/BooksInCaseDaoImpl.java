package com.bookcase.dao.mysql;

import com.bookcase.dao.BooksInCaseDao;
import com.bookcase.dao.DaoException;
import com.bookcase.vo.BookCase;
import com.bookcase.vo.BooksInCase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksInCaseDaoImpl implements BooksInCaseDao {

  Connection con;

  public BooksInCaseDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(BooksInCase booksInCase) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into books_in_case(book_title, bookcase_no) values('%s',%d)",
          booksInCase.getBookTitle(), booksInCase.getBookCaseNo()
      ));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("delete from books_in_case where books_in_case_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<BooksInCase> findAllByCaseNo(int caseNo) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
          String.format("select * from books_in_case where bookcase_no=%d", caseNo));
      List<BooksInCase> list = new ArrayList<>();

      while (rs.next()) {
        BooksInCase booksInCase = new BooksInCase();
        booksInCase.setNo(rs.getInt("books_in_case_no"));
        booksInCase.setBookTitle(rs.getString("book_title"));
        list.add(booksInCase);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
