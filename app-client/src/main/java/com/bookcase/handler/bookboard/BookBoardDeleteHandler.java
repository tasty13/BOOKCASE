package com.bookcase.handler.bookboard;

import com.bookcase.dao.BookBoardDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.util.Prompt;

public class BookBoardDeleteHandler extends AbstractMenuHandler {

  BookBoardDao bookBoardDao;

  public BookBoardDeleteHandler(BookBoardDao bookBoardDao, Prompt prompt) {
    super(prompt);
    this.bookBoardDao = bookBoardDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (bookBoardDao.delete(no) == 0) {
      System.out.println("유효하지 않은 번호입니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
