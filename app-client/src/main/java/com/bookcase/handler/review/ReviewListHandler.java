package com.bookcase.handler.review;

import com.bookcase.dao.ReviewDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.Review;
import com.util.Prompt;

import java.util.List;

public class ReviewListHandler extends AbstractMenuHandler {

  private ReviewDao reviewDao;

  public ReviewListHandler(ReviewDao reviewDao, Prompt prompt) {
    super(prompt);
    this.reviewDao = reviewDao;
  }

  @Override
  public void action() {
    System.out.printf("%-4s\t%-20s\t%s\t%s\n", "번호", "책 제목", "별점", "작성 날짜");

    List<Review> list = reviewDao.findAll();
    for (Review review : list) {
      System.out.printf("%-4d\t%-20s\t%s\t%4$tY-%4$tm-%4$td\n",
              review.getNo(), review.getBookTitle(), review.getScore(),
              review.getCreatedDate());
    }
  }
}
