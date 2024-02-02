package com.bookcase.dao.mysql;

import com.bookcase.dao.BookBoardDao;
import com.bookcase.dao.DaoException;
import com.bookcase.enums.BookBoardStatus;
import com.bookcase.vo.BookBoard;
import com.bookcase.vo.BookCase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookBoardDaoImpl implements BookBoardDao {
  Connection con;

  public BookBoardDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(BookBoard bookBoard) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into book_boards(title,content,writer) values('%s','%s','%s');",
          bookBoard.getTitle(), bookBoard.getContent(), bookBoard.getWriter()
      ));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from book_boards where board_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<BookBoard> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from book_boards");
      List<BookBoard> list = new ArrayList<>();

      while (rs.next()) {
        BookBoard bookBoard = new BookBoard();
        bookBoard.setNo(rs.getInt("board_no"));
        bookBoard.setTitle(rs.getString("title"));
        bookBoard.setWriter(rs.getString("writer"));
        bookBoard.setContent(rs.getString("content"));
        bookBoard.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        list.add(bookBoard);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public BookBoard findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
          String.format("select * from book_boards where board_no=%d", no));

      if (rs.next()) {
        BookBoard bookBoard = new BookBoard();
        bookBoard.setNo(rs.getInt("board_no"));
        bookBoard.setTitle(rs.getString("title"));
        bookBoard.setWriter(rs.getString("writer"));
        bookBoard.setContent(rs.getString("content"));
        bookBoard.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        return bookBoard;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int update(BookBoard bookBoard) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update book_boards set title='%s', content='%s', writer='%s' where board_no=%d",
          bookBoard.getTitle(), bookBoard.getContent(), bookBoard.getWriter(), bookBoard.getNo()
      ));
    } catch (Exception e) {

      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
