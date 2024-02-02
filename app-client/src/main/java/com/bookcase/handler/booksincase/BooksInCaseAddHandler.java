package com.bookcase.handler.booksincase;

import com.bookcase.dao.BooksInCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookCase;
import com.bookcase.vo.BooksInCase;
import com.util.Prompt;
import java.util.Date;

public class BooksInCaseAddHandler extends AbstractMenuHandler {

  BooksInCaseDao booksInCaseDao;

  public BooksInCaseAddHandler(BooksInCaseDao booksInCaseDao, Prompt prompt) {
    super(prompt);
    this.booksInCaseDao = booksInCaseDao;
  }

  @Override
  protected void action() {
    try {
      BooksInCase booksInCase = new BooksInCase();
      booksInCase.setBookTitle(this.prompt.input("책 제목? "));
      booksInCase.setBookCaseNo(this.prompt.inputInt("북케이스 번호? "));

      booksInCaseDao.add(booksInCase);
      System.out.println("등록했습니다.");

    } catch (Exception e) {
      System.out.println("입력 중 오류 발생!");
      System.out.println("다시 시도해 주세요.");
    }
  }
}
