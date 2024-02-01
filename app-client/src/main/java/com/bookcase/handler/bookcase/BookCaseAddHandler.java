package com.bookcase.handler.bookcase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookCase;
import com.util.Prompt;

import java.util.Date;

public class BookCaseAddHandler extends AbstractMenuHandler {

    private BookCaseDao bookCaseDao;

    public BookCaseAddHandler(BookCaseDao bookCaseDao, Prompt prompt) {
        super(prompt);
        this.bookCaseDao = bookCaseDao;
    }

    @Override
    public void action() {
        try {
            BookCase bookCase = new BookCase();
            bookCase.setCaseTitle(this.prompt.input("북케이스 이름? "));
            bookCase.setCreatedDate(new Date());

            bookCaseDao.add(bookCase);
        } catch (Exception e) {
            System.out.println("입력 중 오류 발생!");
            System.out.println("다시 시도해 주세요.");
        }


    }
}
