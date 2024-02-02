package com.bookcase.dao;

import com.bookcase.vo.BooksInCase;
import java.util.List;

public interface BooksInCaseDao {

  void add(BooksInCase booksInCase);

  int delete(int no);

  List<BooksInCase> findAllByCaseNo(int caseNo);
}
