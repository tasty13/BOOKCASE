package com.bookcase.handler.review;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.Review;
import com.util.AnsiEscape;

public class ReviewListHandler implements MenuHandler {

  ReviewRepository reviewRepository;

  public ReviewListHandler(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    System.out.printf("%-20s\t%s\t%-30s\t%s\n", "책 제목", "별점", "후기", "작성 날짜");
    for (Review review : this.reviewRepository.toArray()){
      System.out.printf("%-20s\t%s\t%-30s\t%4$tY-%4$tm-%4$td\n",
              review.bookTitle, review.score, review.comment, review.createdAt);
    }
  }
}
