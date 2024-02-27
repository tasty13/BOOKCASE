package com.bookcase.servlet.user;

import com.bookcase.dao.UserDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.User;
import com.util.Prompt;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/view")
public class UserViewServlet extends HttpServlet {

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

    try{
      int no = Integer.parseInt(request.getParameter("no"));
      User user = userDao.findBy(no);

      if (user == null) {
        out.println("유효하지 않은 번호입니다.");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.println("<form action='/user/update'>");
      out.println("<div>");
      out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", user.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("  이름: <input name='name' type='text' value='%s'>\n", user.getName());
      out.println("</div>");
      out.println("<div>");
      out.printf("  닉네임: <input name='nick' type='text' value='%s'>\n", user.getNick());
      out.println("</div>");
      out.println("<div>");
      out.printf("  이메일: <input readonly name='email' type='text' value='%s'>\n", user.getEmail());
      out.println("</div>");
      out.println("<div>");
      out.printf("  비밀번호: <input name='password' type='password'>\n");
      out.println("</div>");
      out.println("<div>");
      out.printf("  가입 날짜: <input name='created_date' type='text' value='%1$tY-%1$tm-%1$td'>\n",
          user.getCreatedDate());
      out.println("</div>");
      out.println("<div>");
      out.println("  <button>변경</button>");
      out.printf("  <a href='/user/delete?no=%d'>[삭제]</a>\n", no);
      out.println("</div>");
      out.println("</form>");

    } catch (Exception e){

      out.println("<p>조회 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
