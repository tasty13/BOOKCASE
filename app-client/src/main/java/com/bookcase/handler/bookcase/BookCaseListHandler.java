package com.bookcase.handler.bookcase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookCase;
import com.util.Prompt;

import java.util.List;

public class BookCaseListHandler extends AbstractMenuHandler {

    private BookCaseDao bookCaseDao;

    public BookCaseListHandler(BookCaseDao bookCaseDao, Prompt prompt) {
        super(prompt);
        this.bookCaseDao = bookCaseDao;
    }

    @Override
    public void action() {
        System.out.printf("%-4s\t%-15s\t%s\n", "번호", "이름", "생성 날짜");

        List<BookCase> list = bookCaseDao.findAll();

        for (BookCase bookCase : list) {
            System.out.printf("%-4d\t%-15s\t%3$tY-%3$tm-%3$td\n",
                    bookCase.getNo(), bookCase.getCaseTitle(), bookCase.getCreatedDate());
        }
    }
}
