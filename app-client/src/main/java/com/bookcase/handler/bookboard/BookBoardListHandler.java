package com.bookcase.handler.bookboard;

import com.bookcase.dao.BookBoardDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookBoard;
import com.bookcase.vo.Review;
import com.util.Prompt;
import java.util.List;

public class BookBoardListHandler extends AbstractMenuHandler {

  BookBoardDao bookBoardDao;

  public BookBoardListHandler(BookBoardDao bookBoardDao, Prompt prompt) {
    super(prompt);
    this.bookBoardDao = bookBoardDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%10s\t%s\n", "번호", "제목", "작성자", "작성일");

    List<BookBoard> list = bookBoardDao.findAll();
    for (BookBoard bookBoard : list) {
      System.out.printf("%-4s\t%-20s\t%10s\t%4$tY-%4$tm-%4$td\n",
          bookBoard.getNo(), bookBoard.getTitle(), bookBoard.getWriter(), bookBoard.getCreatedDate());
    }
  }
}
