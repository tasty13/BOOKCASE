package com.bookcase.handler.bookcase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookCase;
import com.util.Prompt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookcase/list")
public class BookCaseListHandler extends HttpServlet {

    private BookCaseDao bookCaseDao;

    @Override
    public void init() throws ServletException {
        this.bookCaseDao = (BookCaseDao) this.getServletContext().getAttribute("bookCaseDao");
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
        out.println("<h1>북케이스</h1>");

        out.println("<a href='/review/form.html'>새 북케이스</a>");

        try {
            out.println("<table border='1'>");
            out.println("    <thead>");
            out.println("    <tr> <th>번호</th> <th>이름</th> <th>북마크</th> <th>생성 날짜</th> </tr>");
            out.println("    </thead>");
            out.println("    <tbody>");

            List<BookCase> list = bookCaseDao.findAll();
            for (BookCase bookCase : list) {
                out.printf("<tr> <td>%d</td> <td><a href='/bookcase/view?no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td> </tr>",
                    bookCase.getNo(), bookCase.getCaseTitle(), bookCase.isBookmark(),
                    bookCase.getCreatedDate());
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
