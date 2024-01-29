package com.bookcase.handler.review;

import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.Review;
import com.util.Prompt;

public class ReviewModifyHandler implements MenuHandler {

  ReviewRepository reviewRepository;
  Prompt prompt;

  @Override
  public void action() {
    int index = Integer.parseInt(this.prompt.input("번호: "));
    Review review = this.reviewRepository.reviews[index];
    review.bookTitle = this.prompt.input("책 이름(%s)? ", review.bookTitle);
    review.grade = this.prompt.input("책 별점(%s)? ", review.grade);
    review.comment = this.prompt.input("책 후기(%s)? ", review.comment);
  }
}
