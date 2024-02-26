package com.bookcase.dao;

import com.bookcase.vo.InnerBook;
import java.util.List;

public interface InnerBookDao {

  void add(InnerBook innerBook);

  int delete(int no);

  List<InnerBook> findAllByCaseNo(int caseNo);
}
