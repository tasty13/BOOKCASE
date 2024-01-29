package com.bookcase.handler.review;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.Review;
import com.util.Prompt;

public class ReviewViewHandler implements MenuHandler {

  ReviewRepository reviewRepository;
  Prompt prompt;

  public ReviewViewHandler(ReviewRepository reviewRepository, Prompt prompt) {
    this.reviewRepository = reviewRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    for (int i=0;i<this.reviewRepository.length;i++){
      Review review = this.reviewRepository.reviews[i];
      System.out.println("책 이름: " + review.bookTitle);
      System.out.println("책 별점: " + review.grade);
      System.out.println("책 후기: " + review.comment);
      System.out.println("작성 날짜: " + review.createdDate);
      System.out.println("--------------------------------");
    }
  }
}
