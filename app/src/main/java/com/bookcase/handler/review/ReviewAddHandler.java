package com.bookcase.handler.review;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.Review;
import com.util.AnsiEscape;
import com.util.Prompt;
import java.util.Date;

public class ReviewAddHandler implements MenuHandler {

  ReviewRepository reviewRepository;
  Prompt prompt;

  public ReviewAddHandler(ReviewRepository reviewRepository, Prompt prompt) {
    this.reviewRepository = reviewRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    if (this.reviewRepository.length == this.reviewRepository.reviews.length){
      // 1. 새 사이즈 배열 만듦
      // 2. 원래 배열 요소들 새 배열에 넣어줌
      // 3. reviews 변수에 새 배열 주소 저장해줌
      int oldSize = this.reviewRepository.reviews.length;
      int newSize = oldSize + oldSize / 2;
      Review[] temp = new Review[newSize];
      for (int i = 0; i < oldSize; i++) {
        temp[i] = this.reviewRepository.reviews[i];
      }
      this.reviewRepository.reviews = temp;
    }

    Review review = new Review();
    review.bookTitle = this.prompt.input("책 이름? ");
    review.grade = this.prompt.input("책 별점? ");
    review.comment = this.prompt.input("책 후기? ");
    review.createdDate = new Date();

    this.reviewRepository.reviews[this.reviewRepository.length++] = review;
  }
}
