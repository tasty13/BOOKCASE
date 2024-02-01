package com.bookcase.dao.mysql;

import java.sql.Connection;

public class UserDaoImpl {
  Connection con;

  public UserDaoImpl(Connection con) {
    this.con = con;
  }
}
