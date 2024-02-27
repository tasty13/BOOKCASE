package com.bookcase.servlet.review;

import com.bookcase.dao.ReviewDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.Review;
import com.util.Prompt;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review/update")
public class ReviewUpdateServlet extends HttpServlet {

  private ReviewDao reviewDao;

  @Override
  public void init() throws ServletException {
    this.reviewDao = (ReviewDao) this.getServletContext().getAttribute("reviewDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>리뷰</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Review old = reviewDao.findBy(no);
      if (old == null) {
        out.println("<p>유효하지 않은 번호입니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      Review review = new Review();
      review.setNo(old.getNo());
      review.setBookTitle(old.getBookTitle());
      review.setScore(Integer.parseInt(request.getParameter("score")));
      review.setComment(request.getParameter("comment"));
      review.setCreatedDate(old.getCreatedDate());

      reviewDao.update(review);
      out.println("<p>변경사항을 저장했습니다.</p>");

    } catch (Exception e) {
      out.println("<p>변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
