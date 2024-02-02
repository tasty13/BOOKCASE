package com.bookcase.handler.review;

import com.bookcase.dao.ReviewDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.Review;
import com.util.Prompt;
import java.time.LocalDateTime;
import java.util.Date;

public class ReviewAddHandler extends AbstractMenuHandler {

  private ReviewDao reviewDao;

  public ReviewAddHandler(ReviewDao reviewDao, Prompt prompt) {
    super(prompt);
    this.reviewDao = reviewDao;
  }

  @Override
  public void action() {
    try {
      Review review = new Review();
      review.setBookTitle(this.prompt.input("책 이름? "));
      review.setScore(this.prompt.inputInt("책 별점? "));
      review.setComment(this.prompt.input("책 후기? "));
      review.setCreatedDate(LocalDateTime.now());

      this.reviewDao.add(review);
      System.out.println("등록했습니다.");

    } catch (Exception e) {
      System.out.println("입력 중 오류 발생!");
      System.out.println("다시 시도해 주세요.");
    }
  }
}
