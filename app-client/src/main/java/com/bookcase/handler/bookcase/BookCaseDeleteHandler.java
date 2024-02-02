package com.bookcase.handler.bookcase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.util.Prompt;

public class BookCaseDeleteHandler extends AbstractMenuHandler {
    private BookCaseDao bookCaseDao;

    public BookCaseDeleteHandler(BookCaseDao bookCaseDao, Prompt prompt) {
        super(prompt);
        this.bookCaseDao = bookCaseDao;
    }

    @Override
    public void action() {
        int no = this.prompt.inputInt("번호? ");
        if (bookCaseDao.delete(no) == 0) {
            System.out.println("유효하지 않은 번호입니다.");
        } else {
            System.out.println("삭제했습니다.");
        }
    }
}
