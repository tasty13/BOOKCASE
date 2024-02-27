package com.bookcase.servlet.user;

import com.bookcase.dao.UserDao;
import com.bookcase.vo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {

  private UserDao userDao;

  @Override
  public void init() throws ServletException {
    this.userDao = (UserDao) this.getServletContext().getAttribute("userDao");
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
    out.println("<h1>회원</h1>");

    out.println("<a href='/user/form.html'>새 회원</a>");

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>이름</th> <th>닉네임</th> <th>이메일</th> <th>가입 날짜</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

      List<User> list = userDao.findAll();
      for (User user : list) {
        out.printf("<tr> <td>%d</td> <td><a href='/user/view?no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td> <td>%5$tY-%5$tm-%5$td</td> </tr>",
            user.getNo(), user.getName(), user.getNick(), user.getEmail(), user.getCreatedDate());
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
