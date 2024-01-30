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
        if (this.bookCaseRepository.length == this.bookCaseRepository.bookCases.length) {
            // 1. 새사이즈 배열 만듦
            // 2. 새 배열에 원래 배열 요소 넣어줌
            // 3. 북케이스 변수에 새 배열 주소 저장
            int oldSize = this.bookCaseRepository.bookCases.length;
            int newSize = oldSize + oldSize / 2;
            BookCase[] temp = new BookCase[newSize];
            for (int i = 0; i < oldSize; i++) {
                temp[i] = this.bookCaseRepository.bookCases[i];
            }
            this.bookCaseRepository.bookCases = temp;
        }

        BookCase bookCase = new BookCase();
        bookCase.caseTitle = this.prompt.input("북케이스 이름? ");
        bookCase.createdDate = new Date();

        this.bookCaseRepository.bookCases[this.bookCaseRepository.length++] = bookCase;

    }
}
