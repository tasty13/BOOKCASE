package com.bookcase.menu;

import com.bookcase.vo.BookCase;
import com.util.Prompt;
import java.util.Date;

public class BookCaseMenu implements Menu {

  BookCase[] bookCases = new BookCase[3];
  int length;
  Prompt prompt;
  String title;

  public BookCaseMenu(Prompt prompt, String title) {
    this.prompt = prompt;
    this.title = title;
  }

  public void printMenu() {
    System.out.printf("[%s]\n", this.title);
    System.out.println("1. 생성");
    System.out.println("2. 조회");
    System.out.println("3. 이름 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  public void execute() {
    printMenu();
      while (true) {
        String input = this.prompt.input("메인/%s> ", this.title);
        switch (input) {
          case "1":
            this.add();
            break;
          case "2":
            this.view();
            break;
          case "3":
            this.modify();
            break;
          case "4":
            this.delete();
            break;
          case "5":
            this.list();
            break;
          case "0":
            return;
          case "menu":
            printMenu();
            break;
          default:
            System.out.println("메뉴 번호가 옳지 않습니다.");
            break;
        }
      }
  }

  @Override
  public String getTitle() {
    return null;
  }

  void add(){
    System.out.println("북케이스 생성");
    if (length == bookCases.length) {
        // 1. 새사이즈 배열 만듦
        // 2. 새 배열에 원래 배열 요소 넣어줌
        // 3. 북케이스 변수에 새 배열 주소 저장
        int oldSize = bookCases.length;
        int newSize = oldSize + oldSize / 2;
        BookCase[] temp = new BookCase[newSize];
        for (int i = 0; i < oldSize; i++) {
            temp[i] = bookCases[i];
        }
        bookCases = temp;
    }

    BookCase bookCase = new BookCase();
    bookCase.caseTitle = this.prompt.input("북케이스 이름? ");
    bookCase.createdDate = new Date();

    bookCases[length] = bookCase;
    length++;
    }

    void list(){
        System.out.printf("-15%s\t%s\n", "이름", "생성 날짜");
        for (int i = 0; i < this.length; i++) {
            BookCase bookCase = this.bookCases[i];
            System.out.printf("-15%s\t%2$tY-%2$tm-%2$td\n", bookCase.caseTitle, bookCase.createdDate);
        }
    }

    void view(){
        System.out.println("북케이스 조회");
        for (int i=0;i<this.length;i++){
            BookCase bookCase = this.bookCases[i];
            System.out.println("북케이스 이름: " + bookCase.caseTitle);
            System.out.println("북케이스 생성 날짜: "+bookCase.createdDate);
            System.out.println("--------------------------");
        }
    }
    void modify(){
        System.out.println("북케이스 이름 변경");
        int index = Integer.parseInt(this.prompt.input("번호? "));
        BookCase bookCase = this.bookCases[index];
        bookCase.caseTitle = this.prompt.input("북케이스 이름(%s)? ", bookCase.caseTitle);
    }
    void delete(){
        System.out.println("북케이스 삭제");
        int index = Integer.parseInt(this.prompt.input("번호? "));
        // 1. 배열 인덱스기준으로 한칸씩 앞으로 땡김
        // 2. length 하나 줄임, 배열 마지막값 null
        for (int i = index; i < this.length - 1; i++) {
            this.bookCases[i] = this.bookCases[i + 1];
        }
        this.length--;
        this.bookCases[length] = null;
    }
}
