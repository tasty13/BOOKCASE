package com.bookcase.dao;

import com.bookcase.vo.BookCase;
import com.bookcase.vo.User;
import java.util.List;

public interface UserDao {
  void add(User user);

  int delete(int no);

  List<User> findAll();

  User findBy(int no);

  int update(User user);
}
