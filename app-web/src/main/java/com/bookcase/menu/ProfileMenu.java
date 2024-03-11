package com.bookcase.menu;

import com.util.Prompt;

public class ProfileMenu {

  Prompt prompt;
  String title;

  public ProfileMenu(Prompt prompt, String title) {
    this.prompt = prompt;
    this.title = title;
  }

  public void printMenu() {
    System.out.println("[프로필]");
    System.out.println("1. 내 정보 조회");
    System.out.println("2. 취향 분석");
    System.out.println("3. 좋아한 북케이스");
    System.out.println("0. 이전");
  }

  public void execute() {
    printMenu();

    while (true) {
      String input = this.prompt.input("메인/%s> ", this.title);
      switch (input) {
        case "1":
          myProfile();
          break;
        case "2":
          myTaste();
          break;
        case "3":
          myBookCase();
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
  public void myProfile(){
    System.out.println("내 정보 조회");

  }
  public void myTaste(){
    System.out.println("취향 분석");

  }
  public void myBookCase(){
    System.out.println("좋아한 북케이스");

  }
}
