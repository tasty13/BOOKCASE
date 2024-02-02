package com.bookcase.dao;

import com.bookcase.vo.BookBoard;
import java.util.List;

public interface BookBoardDao {
  void add(BookBoard bookBoard);

  int delete(int no);

  List<BookBoard> findAll();

  BookBoard findBy(int no);

  int update(BookBoard bookBoard);
}
