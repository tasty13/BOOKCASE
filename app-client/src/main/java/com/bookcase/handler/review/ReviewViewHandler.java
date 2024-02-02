package com.bookcase.handler.review;

import com.bookcase.dao.ReviewDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.Review;
import com.util.Prompt;

public class ReviewViewHandler extends AbstractMenuHandler {

  private ReviewDao reviewDao;

  public ReviewViewHandler(ReviewDao reviewDao, Prompt prompt) {
    super(prompt);
    this.reviewDao = reviewDao;
  }

  @Override
  public void action() {
    int no = this.prompt.inputInt("번호? ");
    Review review = reviewDao.findBy(no);
    if (review == null) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    System.out.printf("번호: %d\n", review.getNo());
    System.out.printf("책 제목: %s\n", review.getBookTitle());
    System.out.printf("책 별점: %s\n", review.getScore());
    System.out.printf("책 후기: %s\n", review.getComment());
    System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM\n", review.getCreatedDate());
  }
}
