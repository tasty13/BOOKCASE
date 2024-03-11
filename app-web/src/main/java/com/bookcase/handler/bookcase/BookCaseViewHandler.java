package com.bookcase.handler.bookcase;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.BookCase;
import com.bookcase.vo.Review;
import com.util.AnsiEscape;
import com.util.Prompt;

public class BookCaseViewHandler implements MenuHandler {

    BookCaseRepository bookCaseRepository;
    Prompt prompt;

    public BookCaseViewHandler(BookCaseRepository bookCaseRepository, Prompt prompt) {
        this.bookCaseRepository = bookCaseRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        BookCase bookCase = this.bookCaseRepository.get(index);
        if (bookCase == null) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        System.out.println("북케이스 이름: " + bookCase.caseTitle);
        System.out.println("북케이스 생성 날짜: "+bookCase.createdDate);
    }
}
