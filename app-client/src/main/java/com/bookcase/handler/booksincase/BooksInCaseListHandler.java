package com.bookcase.handler.booksincase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.dao.BooksInCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookCase;
import com.bookcase.vo.BooksInCase;
import com.util.Prompt;
import java.util.List;

public class BooksInCaseListHandler extends AbstractMenuHandler {

  BooksInCaseDao booksInCaseDao;
  BookCaseDao bookCaseDao;

  public BooksInCaseListHandler(BooksInCaseDao booksInCaseDao,BookCaseDao bookCaseDao, Prompt prompt) {
    super(prompt);
    this.booksInCaseDao = booksInCaseDao;
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

    List<BooksInCase> list = booksInCaseDao.findAllByCaseNo(bookCase.getNo());

    for (BooksInCase booksInCase : list) {
      System.out.printf("%-4d\t%-30s\n",
          booksInCase.getNo(), booksInCase.getBookTitle());
    }
  }
}
