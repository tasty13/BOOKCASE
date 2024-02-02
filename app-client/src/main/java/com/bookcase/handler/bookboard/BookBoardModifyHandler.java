package com.bookcase.handler.bookboard;

import com.bookcase.dao.BookBoardDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookBoard;
import com.bookcase.vo.Review;
import com.util.Prompt;

public class BookBoardModifyHandler extends AbstractMenuHandler {

  BookBoardDao bookBoardDao;

  public BookBoardModifyHandler(BookBoardDao bookBoardDao, Prompt prompt) {
    super(prompt);
    this.bookBoardDao = bookBoardDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    BookBoard old = bookBoardDao.findBy(no);
    if (old == null) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    BookBoard bookBoard = new BookBoard();
    bookBoard.setNo(old.getNo());
    bookBoard.setTitle(this.prompt.input("제목(%s)? ", old.getTitle()));
    bookBoard.setWriter(this.prompt.input("작성자(%s)? ", old.getWriter()));
    bookBoard.setContent(this.prompt.input("내용(%s)? ", old.getContent()));
    bookBoard.setCreatedDate(old.getCreatedDate());

    bookBoardDao.update(bookBoard);
    System.out.println("변경사항을 저장했습니다.");
  }
}
