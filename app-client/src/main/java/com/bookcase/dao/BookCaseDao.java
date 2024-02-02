package com.bookcase.dao;

import com.bookcase.vo.BookCase;
import java.util.List;

public interface BookCaseDao {
  void add(BookCase bookCase);

  int delete(int no);

  List<BookCase> findAllByCaseNo();

  BookCase findBy(int no);

  int update(BookCase bookCase);

  int updateBookmark(BookCase bookCase);
}
