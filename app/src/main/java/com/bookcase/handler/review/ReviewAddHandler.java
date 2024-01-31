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

    Review review = new Review();
    review.bookTitle = this.prompt.input("책 이름? ");
    review.grade = this.prompt.input("책 별점? ");
    review.comment = this.prompt.input("책 후기? ");
    review.createdDate = new Date();

    this.reviewRepository.add(review);
  }
}
