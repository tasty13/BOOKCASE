package com.bookcase;

public class ProfileMenu {

  static void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/프로필");
      switch (input) {
        case "1":
          System.out.println("내 정보 조회");
          break;
        case "2":
          System.out.println("취향 분석");
          break;
        case "3":
          System.out.println("좋아한 북케이스");
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }

  static void printMenu() {
    System.out.println("[프로필]");
    System.out.println("1. 내 정보 조회");
    System.out.println("2. 취향 분석");
    System.out.println("3. 좋아한 북케이스");
    System.out.println("0. 이전");
  }
}
