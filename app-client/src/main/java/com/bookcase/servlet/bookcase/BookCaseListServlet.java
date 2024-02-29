package com.bookcase.servlet.bookcase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookCase;
import com.util.Prompt;
import java.util.List;

public class BookCaseListServlet extends AbstractMenuHandler {

    private BookCaseDao bookCaseDao;

    public BookCaseListServlet(BookCaseDao bookCaseDao, Prompt prompt) {
        super(prompt);
        this.bookCaseDao = bookCaseDao;
    }

    @Override
    public void action() {
        System.out.printf("%-4s\t%-15s\t%s\t%s\n", "번호", "이름", "북마크", "생성 날짜");

        List<BookCase> list = bookCaseDao.findAll();

        for (BookCase bookCase : list) {
            System.out.printf("%-4d\t%-15s\t%b\t%4$tY-%4$tm-%4$td\n",
                bookCase.getNo(), bookCase.getCaseTitle(), bookCase.isBookmark(),
                bookCase.getCreatedDate());
        }
    }
}
