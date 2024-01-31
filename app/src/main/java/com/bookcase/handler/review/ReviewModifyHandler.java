package com.bookcase.handler.review;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.Review;
import com.util.AnsiEscape;
import com.util.Prompt;

public class ReviewModifyHandler implements MenuHandler {

  ReviewRepository reviewRepository;
  Prompt prompt;

  public ReviewModifyHandler(ReviewRepository reviewRepository, Prompt prompt) {
    this.reviewRepository = reviewRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = Integer.parseInt(this.prompt.input("번호: "));
    Review old = this.reviewRepository.get(index);
    if (old == null) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    Review review = new Review();
    review.bookTitle = this.prompt.input("책 이름(%s)? ", old.bookTitle);
    review.grade = this.prompt.input("책 별점(%s)? ", old.grade);
    review.comment = this.prompt.input("책 후기(%s)? ", old.comment);

    this.reviewRepository.set(index, review);
  }
}
