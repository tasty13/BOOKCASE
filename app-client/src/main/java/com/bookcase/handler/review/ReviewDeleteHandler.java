package com.bookcase.handler.review;

import com.bookcase.dao.ReviewDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.util.Prompt;

public class ReviewDeleteHandler extends AbstractMenuHandler {

  private ReviewDao reviewDao;

  public ReviewDeleteHandler(ReviewDao reviewDao, Prompt prompt) {
    super(prompt);
    this.reviewDao = reviewDao;
  }

  @Override
  public void action() {
    int no = this.prompt.inputInt("번호? ");
    if (reviewDao.delete(no) == 0) {
      System.out.println("유효하지 않은 번호입니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
