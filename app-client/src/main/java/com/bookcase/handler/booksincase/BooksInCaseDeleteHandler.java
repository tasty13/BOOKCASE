package com.bookcase.handler.booksincase;

import com.bookcase.dao.InnerBookDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.util.Prompt;

public class BooksInCaseDeleteHandler extends AbstractMenuHandler {

  InnerBookDao innerBookDao;

  public BooksInCaseDeleteHandler(InnerBookDao innerBookDao, Prompt prompt) {
    super(prompt);
    this.innerBookDao = innerBookDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (innerBookDao.delete(no) == 0) {
      System.out.println("유효하지 않은 번호입니다.");
    } else {
      System.out.println("삭제했습니다.");
    }
  }
}
