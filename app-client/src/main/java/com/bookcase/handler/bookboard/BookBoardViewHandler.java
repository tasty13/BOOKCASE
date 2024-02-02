package com.bookcase.handler.bookboard;

import com.bookcase.dao.BookBoardDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookBoard;
import com.bookcase.vo.Review;
import com.util.Prompt;

public class BookBoardViewHandler extends AbstractMenuHandler {

  BookBoardDao bookBoardDao;

  public BookBoardViewHandler(BookBoardDao bookBoardDao, Prompt prompt) {
    super(prompt);
    this.bookBoardDao = bookBoardDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    BookBoard bookBoard = bookBoardDao.findBy(no);
    if (bookBoard == null) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    System.out.printf("번호: %d\n", bookBoard.getNo());
    System.out.printf("제목: %s\n", bookBoard.getTitle());
    System.out.printf("작성자: %s\n", bookBoard.getWriter());
    System.out.printf("내용: %s\n", bookBoard.getContent());
    System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM\n", bookBoard.getCreatedDate());
  }

}
