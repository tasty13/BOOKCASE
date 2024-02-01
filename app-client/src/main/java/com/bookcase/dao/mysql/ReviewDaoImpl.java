package com.bookcase.dao.mysql;

import java.sql.Connection;

public class ReviewDaoImpl {
  Connection con;

  public ReviewDaoImpl(Connection con) {
    this.con = con;
  }
}
