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

@WebServlet("/review/view")
public class ReviewViewServlet extends HttpServlet {

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

      Review review = reviewDao.findBy(no);
      if (review == null) {
//          throw new Exception("<p>과제 번호가 유효하지 않습니다.</p>");
        System.out.println("유효하지 않은 번호입니다.");
        return;
      }

      out.println("<form action='/view/update' method='post'>");
      out.println("<div>");
      out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", review.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("  책 제목: <input name='title' type='text' value='%s'>\n", review.getBookTitle());
      out.println("</div>");
      out.println("<div>");
      out.printf("  별점: <input name='score' type='text' value='%d'>\n", review.getScore());
      out.println("</div>");
      out.println("<div>");
      out.printf("  후기: <textarea name='content'>%s</textarea>\n", review.getComment());
      out.println("</div>");
      out.println("<div>");
      out.printf(
          "  작성일: <input readonly name='created_date' type='text' value='%1$tY-%1$tm-%1$td %1$tH:%1$tM'>\n",
          review.getCreatedDate());
      out.println("</div>");
      out.println("<div>");
      out.println("  <button>변경</button>");
      out.printf("  <a href='/view/delete?no=%d'>[삭제]</a>\n", no);
      out.println("</div>");
      out.println("</form>");

      } catch (Exception e) {
        throw new RuntimeException(e);
    }

    out.println("</body>");
    out.println("</html>");

  }
}
