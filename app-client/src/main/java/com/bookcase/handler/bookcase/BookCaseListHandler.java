package com.bookcase.handler.bookcase;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.BookCase;
import com.util.AnsiEscape;
import com.util.Prompt;

public class BookCaseListHandler implements MenuHandler {

    BookCaseRepository bookCaseRepository;

    public BookCaseListHandler(BookCaseRepository bookCaseRepository) {
        this.bookCaseRepository = bookCaseRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        System.out.printf("%-15s\t%s\n", "이름", "생성 날짜");
        for (BookCase bookCase : this.bookCaseRepository.toArray()) {
            System.out.printf("%-15s\t%2$tY-%2$tm-%2$td\n", bookCase.caseTitle, bookCase.createdDate);
        }
    }
}
