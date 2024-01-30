package com.bookcase;

import com.bookcase.handler.ProfileHandler;
import com.bookcase.handler.bookcase.*;
import com.bookcase.handler.review.*;
import com.bookcase.handler.user.*;
import com.bookcase.menu.MainMenu;
import com.bookcase.menu.MenuGroup;
import com.bookcase.menu.MenuItem;
import com.util.Prompt;

public class App {

  // 애플리케이션 객체 App 실행할 떄 다음 변수를 미리 준비해 둔다.
  // -> 속도 빨라짐!
  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);

    ReviewRepository reviewRepository = new ReviewRepository();
    BookCaseRepository bookCaseRepository = new BookCaseRepository();
    UserRepository userRepository = new UserRepository();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup reviewMenu = new MenuGroup("독서록");
    reviewMenu.add(new MenuItem("등록", new ReviewAddHandler(reviewRepository, prompt)));
    reviewMenu.add(new MenuItem("조회", new ReviewViewHandler(reviewRepository, prompt)));
    reviewMenu.add(new MenuItem("변경", new ReviewModifyHandler(reviewRepository, prompt)));
    reviewMenu.add(new MenuItem("삭제", new ReviewDeleteHandler(reviewRepository, prompt)));
    reviewMenu.add(new MenuItem("목록", new ReviewListHandler(reviewRepository)));
    mainMenu.add(reviewMenu);

    MenuGroup bookCaseMenu = new MenuGroup("북케이스");
    bookCaseMenu.add(new MenuItem("등록", new BookCaseAddHandler(bookCaseRepository, prompt)));
    bookCaseMenu.add(new MenuItem("조회", new BookCaseViewHandler(bookCaseRepository, prompt)));
    bookCaseMenu.add(new MenuItem("변경", new BookCaseModifyHandler(bookCaseRepository, prompt)));
    bookCaseMenu.add(new MenuItem("삭제", new BookCaseDeleteHandler(bookCaseRepository, prompt)));
    bookCaseMenu.add(new MenuItem("목록", new BookCaseListHandler(bookCaseRepository)));
    mainMenu.add(bookCaseMenu);

    MenuGroup userMenu = new MenuGroup("회원");
    userMenu.add(new MenuItem("등록", new UserAddHandler(userRepository, prompt)));
    userMenu.add(new MenuItem("조회", new UserViewHandler(userRepository, prompt)));
    userMenu.add(new MenuItem("변경", new UserModifyHandler(userRepository, prompt)));
    userMenu.add(new MenuItem("삭제", new UserDeleteHandler(userRepository, prompt)));
    userMenu.add(new MenuItem("목록", new UserListHandler(userRepository)));
    mainMenu.add(userMenu);

    mainMenu.add(new MenuItem("프로필", new ProfileHandler()));

    mainMenu.execute(prompt);

    prompt.close(); // Prompt쪽에서 keyIn 자원해제(close)시키도록 함. (참견X)
  }
}
