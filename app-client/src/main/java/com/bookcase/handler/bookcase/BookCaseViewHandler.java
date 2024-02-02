package com.bookcase.handler.bookcase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookCase;
import com.util.Prompt;

public class BookCaseViewHandler extends AbstractMenuHandler {

    private BookCaseDao bookCaseDao;

    public BookCaseViewHandler(BookCaseDao bookCaseDao, Prompt prompt) {
        super(prompt);
        this.bookCaseDao = bookCaseDao;
    }

    @Override
    public void action() {
        int no = this.prompt.inputInt("번호? ");
        BookCase bookCase = bookCaseDao.findBy(no);
        if (bookCase == null) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        System.out.printf("번호: %d\n", bookCase.getNo());
        System.out.printf("이름: %s\n", bookCase.getCaseTitle());
        System.out.printf("생성 날짜: %1$tY-%1$tm-%1$td\n", bookCase.getCreatedDate());
    }
}
