package com.bookcase.servlet.user;

import static java.lang.System.out;

import com.bookcase.dao.UserDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.User;
import com.util.Prompt;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/update")
public class UserUpdateServlet extends HttpServlet {

  private UserDao userDao;

  @Override
  public void init() throws ServletException {
    this.userDao = (UserDao) this.getServletContext().getAttribute("userDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));

    try {
      User old = userDao.findBy(no);
      if (old == null) {
        out.println("<p>유효하지 않은 번호입니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      User user = new User();
      user.setNo(old.getNo());
      user.setEmail(request.getParameter("email"));
      user.setName(request.getParameter("name"));
      user.setNick(request.getParameter("nick"));
      user.setPassword(request.getParameter("password"));
      user.setCreatedDate(old.getCreatedDate());

      userDao.update(user);
      out.println("<p>변경사항을 저장했습니다.</p>");

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
