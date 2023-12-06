package com.bookcase;

public class ReviewMenu {

  static void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/독서록");
      switch (input) {
        case "1":
          System.out.println("등록");
          break;
        case "2":
          System.out.println("조회");
          break;
        case "3":
          System.out.println("변경");
          break;
        case "4":
          System.out.println("삭제");
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

  static void printMenu() {
    System.out.println("[독서록]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }
}
