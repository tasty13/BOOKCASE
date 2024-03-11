package com.bookcase.handler.bookcase;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.util.AnsiEscape;
import com.util.Prompt;

public class BookCaseDeleteHandler implements MenuHandler {
    BookCaseRepository bookCaseRepository;
    Prompt prompt;

    public BookCaseDeleteHandler(BookCaseRepository bookCaseRepository, Prompt prompt) {
        this.bookCaseRepository = bookCaseRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = Integer.parseInt(this.prompt.input("번호? "));
        if (bookCaseRepository.remove(index) == null) {
            System.out.println("유효하지 않은 번호입니다.");
        }
    }
}
