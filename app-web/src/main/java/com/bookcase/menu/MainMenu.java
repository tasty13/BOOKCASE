package com.bookcase.menu;

import com.bookcase.vo.BookCase;
import com.util.Prompt;

import static com.util.AnsiEscape.*;

public class MainMenu {

  static final String APP_TITLE = ANSI_BOLD_RED + "[독서록]" + ANSI_CLEAR;
  static final String[] MENUS = {
      "1. 독서록",
      "2. 내 북케이스",
      "3. 회원",
      "4. 프로필",
      ANSI_RED + "0. 종료" + ANSI_CLEAR
  };

  Prompt prompt;

  public MainMenu(Prompt prompt) {
    this.prompt = prompt;
  }

  public static void printMenu() {
    // ANSI 코드와 App 제목, 메뉴를 저장한 변수를 메서드 안에 두는 대신에 클래스 블록 안에 두면
    // printMenu()를 호출할 때마다 변수를 만들지 않기 때문에
    // 실행 속도나 메모리 부분에서 훨씬 효율적이다.
    // 보통 메서드가 호출될 때마다 값이 바뀌는 변수가 아니라 고정 값을 갖는 변수인 경우
    // 메서드 밖에 두는 것이 좋다.

    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  public void execute() {
    ReviewMenu reviewMenu = new ReviewMenu(this.prompt, "독서록");
    BookCaseMenu bookCaseMenu = new BookCaseMenu(this.prompt, "북케이스");
    UserMenu userMenu = new UserMenu(this.prompt, "유저");
    ProfileMenu profileMenu = new ProfileMenu(this.prompt, "프로필");
    
    printMenu();

    while (true) {
      String input = this.prompt.input("메인> ");

      switch (input) {
        case "1":
          reviewMenu.execute();
          break;
        case "2":
          bookCaseMenu.execute();
          break;
        case "3":
          userMenu.execute();
          break;
        case "4":
          profileMenu.execute();
          break;
        case "0":
          System.out.println("종료합니다.");
          return;
        case "menu":
          // 코드를 기능 단위로 묶어 메서드로 정의하면
          // 메서드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋다.
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}
