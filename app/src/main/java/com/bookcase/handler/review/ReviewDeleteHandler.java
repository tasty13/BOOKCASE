package com.bookcase.handler.review;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.util.AnsiEscape;
import com.util.Prompt;

public class ReviewDeleteHandler implements MenuHandler {

  ReviewRepository reviewRepository;
  Prompt prompt;

  public ReviewDeleteHandler(ReviewRepository reviewRepository, Prompt prompt) {
    this.reviewRepository = reviewRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = Integer.parseInt(this.prompt.input("번호: "));
    if (reviewRepository.remove(index) == null){
      System.out.println("유효하지 않은 번호입니다.");
    }
  }
}
