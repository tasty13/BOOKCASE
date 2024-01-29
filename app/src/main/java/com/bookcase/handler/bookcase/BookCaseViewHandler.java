package com.bookcase.handler.bookcase;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.BookCase;

public class BookCaseViewHandler implements MenuHandler {

    BookCaseRepository bookCaseRepository;

    @Override
    public void action(Menu menu) {
        System.out.println("북케이스 조회");
        for (int i=0;i<this.bookCaseRepository.length;i++){
            BookCase bookCase = this.bookCaseRepository.bookCases[i];
            System.out.println("북케이스 이름: " + bookCase.caseTitle);
            System.out.println("북케이스 생성 날짜: "+bookCase.createdDate);
            System.out.println("--------------------------");
        }
    }
}
