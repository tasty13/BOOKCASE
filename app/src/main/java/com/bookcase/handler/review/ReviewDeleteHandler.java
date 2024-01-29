package com.bookcase.handler.review;

import com.bookcase.menu.MenuHandler;
import com.util.Prompt;

public class ReviewDeleteHandler implements MenuHandler {

  ReviewRepository reviewRepository;
  Prompt prompt;

  @Override
  public void action() {
    int index = Integer.parseInt(this.prompt.input("번호: "));
    for (int i = index; i<this.reviewRepository.length-1; i++){
      this.reviewRepository.reviews[i] = this.reviewRepository.reviews[i + 1];
    }
    this.reviewRepository.reviews[--this.reviewRepository.length] = null;
  }
}
