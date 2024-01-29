package com.bookcase.handler.bookcase;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.BookCase;
import com.util.Prompt;

public class BookCaseListHandler implements MenuHandler {

    BookCaseRepository bookCaseRepository;

    public BookCaseListHandler(BookCaseRepository bookCaseRepository) {
        this.bookCaseRepository = bookCaseRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf("-15%s\t%s\n", "이름", "생성 날짜");
        for (int i = 0; i < this.bookCaseRepository.length; i++) {
            BookCase bookCase = this.bookCaseRepository.bookCases[i];
            System.out.printf("-15%s\t%2$tY-%2$tm-%2$td\n", bookCase.caseTitle, bookCase.createdDate);
        }
    }
}
