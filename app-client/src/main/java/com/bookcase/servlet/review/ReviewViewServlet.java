package com.bookcase.servlet.review;

import com.bookcase.dao.ReviewDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.Review;
import com.util.Prompt;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review/view")
public class ReviewViewServlet extends HttpServlet {

  private ReviewDao reviewDao;

  @Override
  public void init() throws ServletException {
    this.reviewDao = (ReviewDao) this.getServletContext().getAttribute("reviewDao");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int no = this.prompt.inputInt("번호? ");
    Review review = reviewDao.findBy(no);
    if (review == null) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    System.out.printf("번호: %d\n", review.getNo());
    System.out.printf("책 제목: %s\n", review.getBookTitle());
    System.out.printf("책 별점: %s\n", review.getScore());
    System.out.printf("책 후기: %s\n", review.getComment());
    System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM\n", review.getCreatedDate());
  }
}
