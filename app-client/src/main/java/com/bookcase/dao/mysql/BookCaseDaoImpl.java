package com.bookcase.dao.mysql;

import java.sql.Connection;

public class BookCaseDaoImpl {
  Connection con;

  public BookCaseDaoImpl(Connection con) {
    this.con = con;
  }
}
