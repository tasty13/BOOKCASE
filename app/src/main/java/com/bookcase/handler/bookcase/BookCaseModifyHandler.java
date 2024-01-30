package com.bookcase.handler.bookcase;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.BookCase;
import com.util.Prompt;

public class BookCaseModifyHandler implements MenuHandler {

    BookCaseRepository bookCaseRepository;
    Prompt prompt;

    public BookCaseModifyHandler(BookCaseRepository bookCaseRepository, Prompt prompt) {
        this.bookCaseRepository = bookCaseRepository;
        this.prompt = prompt;
    }

    @Override
    public void action(Menu menu) {
        System.out.println("북케이스 이름 변경");
        int index = Integer.parseInt(this.prompt.input("번호? "));
        BookCase bookCase = this.bookCaseRepository.bookCases[index];
        bookCase.caseTitle = this.prompt.input("북케이스 이름(%s)? ", bookCase.caseTitle);
    }
}