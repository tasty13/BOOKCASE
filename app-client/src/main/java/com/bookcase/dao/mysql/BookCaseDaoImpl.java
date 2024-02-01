package com.bookcase.dao.mysql;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.vo.BookCase;

import java.sql.Connection;
import java.util.List;

public class BookCaseDaoImpl implements BookCaseDao{
  Connection con;

  public BookCaseDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(BookCase bookCase) {

  }

  @Override
  public int delete(int no) {
    return 0;
  }

  @Override
  public List<BookCase> findAll() {
    return null;
  }

  @Override
  public BookCase findBy(int no) {
    return null;
  }

  @Override
  public int update(BookCase bookCase) {
    return 0;
  }
}
