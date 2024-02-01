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

        System.out.println("번호: " + bookCase.getNo());
        System.out.println("이름: " + bookCase.getCaseTitle());
        System.out.println("생성 날짜: "+bookCase.getCreatedDate());
    }
}
