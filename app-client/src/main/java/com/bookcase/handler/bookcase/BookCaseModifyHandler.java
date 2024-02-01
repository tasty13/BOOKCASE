package com.bookcase.handler.bookcase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.BookCase;
import com.util.Prompt;

public class BookCaseModifyHandler extends AbstractMenuHandler {

    private BookCaseDao bookCaseDao;

    public BookCaseModifyHandler(BookCaseDao bookCaseDao, Prompt prompt) {
        super(prompt);
        this.bookCaseDao = bookCaseDao;
    }

    @Override
    public void action() {

        int no = this.prompt.inputInt("번호? ");

        BookCase old = this.bookCaseDao.findBy(no);
        if (old == null) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        BookCase bookCase = new BookCase();
        bookCase.setNo(old.getNo());
        bookCase.setCaseTitle(this.prompt.input("북케이스 이름(%s)? ", old.getCaseTitle()));
        bookCase.setCreatedDate(old.getCreatedDate());

        bookCaseDao.update(bookCase);
        System.out.println("변경사항을 저장했습니다.");
    }
}
