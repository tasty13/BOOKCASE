package com.bookcase.handler.review;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.Review;
import com.util.AnsiEscape;
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
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.reviewRepository.length) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    Review review = this.reviewRepository.reviews[index];
    System.out.println("책 이름: " + review.bookTitle);
    System.out.println("책 별점: " + review.grade);
    System.out.println("책 후기: " + review.comment);
    System.out.println("작성 날짜: " + review.createdDate);
  }
}
