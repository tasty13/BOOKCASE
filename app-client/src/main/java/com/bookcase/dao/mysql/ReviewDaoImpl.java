package com.bookcase.dao.mysql;

import com.bookcase.dao.ReviewDao;
import com.bookcase.vo.Review;

import java.sql.Connection;
import java.util.List;

public class ReviewDaoImpl implements ReviewDao {
  Connection con;

  public ReviewDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Review review) {

  }

  @Override
  public int delete(int no) {
    return 0;
  }

  @Override
  public List<Review> findAll() {
    return null;
  }

  @Override
  public Review findBy(int no) {
    return null;
  }

  @Override
  public int update(Review review) {
    return 0;
  }
}
