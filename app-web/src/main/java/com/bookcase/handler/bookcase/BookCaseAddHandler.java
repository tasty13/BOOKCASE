package com.bookcase.handler.bookcase;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.BookCase;
import com.util.AnsiEscape;
import com.util.Prompt;

import java.util.Date;

public class BookCaseAddHandler implements MenuHandler {

    BookCaseRepository bookCaseRepository;
    Prompt prompt;

    public BookCaseAddHandler(BookCaseRepository bookCaseRepository, Prompt prompt) {
        this.bookCaseRepository = bookCaseRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());


        BookCase bookCase = new BookCase();
        bookCase.caseTitle = this.prompt.input("북케이스 이름? ");
        bookCase.createdDate = new Date();

        this.bookCaseRepository.add(bookCase);

    }
}
