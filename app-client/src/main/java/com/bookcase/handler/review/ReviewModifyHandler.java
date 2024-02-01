package com.bookcase.handler.review;

import com.bookcase.dao.ReviewDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.Review;
import com.util.Prompt;

public class ReviewModifyHandler extends AbstractMenuHandler {

  private ReviewDao reviewDao;

  public ReviewModifyHandler(ReviewDao reviewDao, Prompt prompt) {
    super(prompt);
    this.reviewDao = reviewDao;
  }

  @Override
  public void action() {
    int no = this.prompt.inputInt("번호? ");
    Review old = reviewDao.findBy(no);
    if (old == null) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    Review review = new Review();
    review.setNo(old.getNo());
    review.setBookTitle(old.getBookTitle());
    review.setScore(this.prompt.inputInt("책 별점(%d)? ", old.getScore()));
    review.setComment(this.prompt.input("책 후기(%s)? ", old.getComment()));
    review.setCreatedDate(old.getCreatedDate());

    reviewDao.update(review);
    System.out.println("변경사항을 저장했습니다.");
  }
}
