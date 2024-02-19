package com.bookcase.dao.mysql;

import com.bookcase.dao.BookBoardDao;
import com.bookcase.dao.DaoException;
import com.bookcase.vo.BookBoard;
import com.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookBoardDaoImpl implements BookBoardDao {
  DBConnectionPool connectionPool;

  public BookBoardDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(BookBoard bookBoard) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "insert into book_boards(title,content,writer) values(?,?,?);")) {

      pstmt.setString(1, bookBoard.getTitle());
      pstmt.setString(2, bookBoard.getContent());
      pstmt.setString(3, bookBoard.getWriter());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "delete from book_boards where board_no=?")) {

      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public List<BookBoard> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "select board_no, title, writer, content, created_date from book_boards order by board_no desc");
        ResultSet rs = pstmt.executeQuery()) {

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
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from book_boards where board_no=?")){
      pstmt.setInt(1, no);
      try (ResultSet rs = pstmt.executeQuery()) {
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
      }

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 오류", e);
    }
  }

  @Override
  public int update(BookBoard bookBoard) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
        "update book_boards set title=?, content=?, writer=? where board_no=?")) {

      pstmt.setString(1, bookBoard.getTitle());
      pstmt.setString(2, bookBoard.getContent());
      pstmt.setString(3, bookBoard.getWriter());
      pstmt.setInt(4, bookBoard.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {

      throw new DaoException("데이터 불러오기 오류", e);
    }
  }
}
