package com.bookcase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.dao.ReviewDao;
import com.bookcase.dao.UserDao;
import com.bookcase.handler.bookcase.*;
import com.bookcase.handler.review.*;
import com.bookcase.handler.user.*;
import com.bookcase.menu.MenuGroup;
import com.bookcase.menu.MenuItem;
import com.util.Prompt;

public class App {

  Prompt prompt = new Prompt(System.in);
  BookCaseDao bookCaseDao;
  ReviewDao reviewDao;
  UserDao userDao;

  MenuGroup mainMenu;

  App() {
    prepareDatabase();
    prepareMenu();
  }

  private void prepareDatabase() {
  }

  private void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup reviewMenu = mainMenu.addGroup("독서록");
    reviewMenu.addItem("등록", new ReviewAddHandler(reviewRepository, prompt));
    reviewMenu.addItem("조회", new ReviewViewHandler(reviewRepository, prompt));
    reviewMenu.addItem("변경", new ReviewModifyHandler(reviewRepository, prompt));
    reviewMenu.addItem("삭제", new ReviewDeleteHandler(reviewRepository, prompt));
    reviewMenu.addItem("목록", new ReviewListHandler(reviewRepository));
    mainMenu.add(reviewMenu);

    MenuGroup bookCaseMenu = mainMenu.addGroup("북케이스");
    bookCaseMenu.addItem("등록", new BookCaseAddHandler(bookCaseRepository, prompt));
    bookCaseMenu.addItem("조회", new BookCaseViewHandler(bookCaseRepository, prompt));
    bookCaseMenu.addItem("변경", new BookCaseModifyHandler(bookCaseRepository, prompt));
    bookCaseMenu.addItem("삭제", new BookCaseDeleteHandler(bookCaseRepository, prompt));
    bookCaseMenu.addItem("목록", new BookCaseListHandler(bookCaseRepository));
    mainMenu.add(bookCaseMenu);

    MenuGroup userMenu = mainMenu.addGroup("회원");
    userMenu.addItem("등록", new UserAddHandler(userRepository, prompt));
    userMenu.addItem("조회", new UserViewHandler(userRepository, prompt));
    userMenu.addItem("변경", new UserModifyHandler(userRepository, prompt));
    userMenu.addItem("삭제", new UserDeleteHandler(userRepository, prompt));
    userMenu.addItem("목록", new UserListHandler(userRepository));
    mainMenu.add(userMenu);

    mainMenu.execute(prompt);
  }

  // 애플리케이션 객체 App 실행할 떄 다음 변수를 미리 준비해 둔다.
  // -> 속도 빨라짐!
  public static void main(String[] args) {



    prompt.close(); // Prompt쪽에서 keyIn 자원해제(close)시키도록 함. (참견X)
  }
}
