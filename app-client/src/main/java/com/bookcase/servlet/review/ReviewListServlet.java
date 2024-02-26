package com.bookcase.servlet.review;

import com.bookcase.dao.ReviewDao;
import com.bookcase.dao.mysql.ReviewDaoImpl;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.Review;
import com.util.DBConnectionPool;
import com.util.Prompt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review/list")
public class ReviewListServlet extends HttpServlet {

  private ReviewDao reviewDao;

  @Override
  public void init() throws ServletException {
    this.reviewDao = (ReviewDao) this.getServletContext().getAttribute("reviewDao");
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
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

    out.println("<a href='/assignment/form.html'>새 리뷰</a>");

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>책 제목</th> <th>별점</th> <th>작성 날짜</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

      List<Review> list = reviewDao.findAll();
      for (Review review : list) {
        out.printf("<tr> <td>%d</td> <td><a href='/review/view?no=%1$d'>%s</a></td> <td>%d</td> <td>%s</td> </tr>",
                review.getNo(), review.getBookTitle(), review.getScore(),
                review.getCreatedDate());
      }

      out.println("    </tbody>");
      out.println("</table>");

    } catch (Exception e) {
      out.println("<p>목록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
