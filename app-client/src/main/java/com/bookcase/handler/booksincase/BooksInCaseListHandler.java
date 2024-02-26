package com.bookcase.handler.booksincase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.dao.InnerBookDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookCase;
import com.bookcase.vo.InnerBook;
import com.util.Prompt;
import java.util.List;

public class BooksInCaseListHandler extends AbstractMenuHandler {

  InnerBookDao innerBookDao;
  BookCaseDao bookCaseDao;

  public BooksInCaseListHandler(InnerBookDao innerBookDao,BookCaseDao bookCaseDao, Prompt prompt) {
    super(prompt);
    this.innerBookDao = innerBookDao;
    this.bookCaseDao = bookCaseDao;

  }

  @Override
  protected void action() {
    int caseNo = this.prompt.inputInt("북케이스 번호? ");
    BookCase bookCase = bookCaseDao.findBy(caseNo);
    if (bookCase == null) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    System.out.printf("%-4s\t%-30s\n", "번호", "책 제목");

    List<InnerBook> list = innerBookDao.findAllByCaseNo(bookCase.getNo());

    for (InnerBook innerBook : list) {
      System.out.printf("%-4d\t%-30s\n",
          innerBook.getNo(), innerBook.getBookTitle());
    }
  }
}
