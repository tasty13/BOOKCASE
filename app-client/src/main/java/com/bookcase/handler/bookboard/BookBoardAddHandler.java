package com.bookcase.handler.bookboard;

import com.bookcase.dao.BookBoardDao;
import com.bookcase.enums.BookBoardStatus;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookBoard;
import com.bookcase.vo.Review;
import com.util.Prompt;
import java.time.LocalDateTime;

public class BookBoardAddHandler extends AbstractMenuHandler {

  BookBoardDao bookBoardDao;

  public BookBoardAddHandler(BookBoardDao bookBoardDao, Prompt prompt) {
    super(prompt);
    this.bookBoardDao = bookBoardDao;
  }

  @Override
  protected void action() {
    try {
      BookBoard bookBoard = new BookBoard();
      bookBoard.setTitle(this.prompt.input("제목? "));
      bookBoard.setWriter(this.prompt.input("작성자? "));
      bookBoard.setContent(this.prompt.input("내용? "));
      bookBoard.setCreatedDate(LocalDateTime.now());

      this.bookBoardDao.add(bookBoard);
      System.out.println("등록했습니다.");

    } catch (Exception e) {
      System.out.println("입력 중 오류 발생!");
      System.out.println("다시 시도해 주세요.");
    }
  }
}
