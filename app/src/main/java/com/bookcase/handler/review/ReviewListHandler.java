package com.bookcase.handler.review;

import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.Review;
import com.util.Prompt;

public class ReviewListHandler implements MenuHandler {

  ReviewRepository reviewRepository;
  Prompt prompt;

  public ReviewListHandler(ReviewRepository reviewRepository, Prompt prompt) {
    this.reviewRepository = reviewRepository;
    this.prompt = prompt;
  }

  @Override
  public void action() {
    System.out.printf("%-20s\t%s\t%-30s\t%s\n", "책 제목", "별점", "후기", "작성 날짜");
    for (int i = 0; i < this.reviewRepository.length; i++) {
      Review review = this.reviewRepository.reviews[i];
      System.out.printf("%-20s\t%s\t%-30s\t%4$tY-%4$tm-%4$td\n",
          review.bookTitle, review.grade, review.comment, review.createdDate);
    }
  }
}
