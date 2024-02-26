package com.bookcase.handler.booksincase;

import com.bookcase.dao.InnerBookDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.InnerBook;
import com.util.Prompt;

public class BooksInCaseAddHandler extends AbstractMenuHandler {

  InnerBookDao innerBookDao;

  public BooksInCaseAddHandler(InnerBookDao innerBookDao, Prompt prompt) {
    super(prompt);
    this.innerBookDao = innerBookDao;
  }

  @Override
  protected void action() {
    try {
      InnerBook innerBook = new InnerBook();
      innerBook.setBookTitle(this.prompt.input("책 제목? "));
      innerBook.setBookCaseNo(this.prompt.inputInt("북케이스 번호? "));

      innerBookDao.add(innerBook);
      System.out.println("등록했습니다.");

    } catch (Exception e) {
      System.out.println("입력 중 오류 발생!");
      System.out.println("다시 시도해 주세요.");
    }
  }
}
