package com.bookcase.handler.booksincase;

import com.bookcase.dao.BooksInCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.util.Prompt;

public class BooksInCaseDeleteHandler extends AbstractMenuHandler {

  BooksInCaseDao booksInCaseDao;

  public BooksInCaseDeleteHandler(BooksInCaseDao booksInCaseDao, Prompt prompt) {
    super(prompt);
    this.booksInCaseDao = booksInCaseDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (booksInCaseDao.delete(no) == 0) {
      System.out.println("유효하지 않은 번호입니다.");
    } else {
      System.out.println("삭제했습니다.");
    }
  }
}
