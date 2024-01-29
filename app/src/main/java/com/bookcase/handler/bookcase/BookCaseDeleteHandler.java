package com.bookcase.handler.bookcase;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.util.Prompt;

public class BookCaseDeleteHandler implements MenuHandler {
    BookCaseRepository bookCaseRepository;
    Prompt prompt;

    @Override
    public void action(Menu menu) {
        System.out.println("북케이스 삭제");
        int index = Integer.parseInt(this.prompt.input("번호? "));
        // 1. 배열 인덱스기준으로 한칸씩 앞으로 땡김
        // 2. length 하나 줄임, 배열 마지막값 null
        for (int i = index; i < this.bookCaseRepository.length - 1; i++) {
            this.bookCaseRepository.bookCases[i] = this.bookCaseRepository.bookCases[i + 1];
        }
        this.bookCaseRepository.bookCases[--this.bookCaseRepository.length] = null;
    }
}
