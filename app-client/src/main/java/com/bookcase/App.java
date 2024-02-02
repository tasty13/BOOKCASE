package com.bookcase;

import com.bookcase.dao.BookCaseDao;
import com.bookcase.dao.BooksInCaseDao;
import com.bookcase.dao.ReviewDao;
import com.bookcase.dao.UserDao;
import com.bookcase.dao.mysql.BookCaseDaoImpl;
import com.bookcase.dao.mysql.BooksInCaseDaoImpl;
import com.bookcase.dao.mysql.ReviewDaoImpl;
import com.bookcase.dao.mysql.UserDaoImpl;
import com.bookcase.handler.bookcase.*;
import com.bookcase.handler.booksincase.BooksInCaseAddHandler;
import com.bookcase.handler.booksincase.BooksInCaseDeleteHandler;
import com.bookcase.handler.booksincase.BooksInCaseListHandler;
import com.bookcase.handler.review.*;
import com.bookcase.handler.user.*;
import com.bookcase.menu.MenuGroup;
import com.util.Prompt;

import java.sql.Connection;
import java.sql.DriverManager;

public class App {

  Prompt prompt = new Prompt(System.in);
  ReviewDao reviewDao;
  BookCaseDao bookCaseDao;
  UserDao userDao;
  BooksInCaseDao booksInCaseDao;

  MenuGroup mainMenu;

  App() {
    prepareDatabase();
    prepareMenu();
  }

  // 애플리케이션 객체 App 실행할 떄 다음 변수를 미리 준비해 둔다.
  // -> 속도 빨라짐!
  public static void main(String[] args) {
    System.out.println("[북케이스]");
    new App().run();
  }

  private void prepareDatabase() {
    try {
      // JVM이 JDBC 드라이버 파일(.jar)에 설정된대로 자동으로 처리한다.
//      Driver driver = new com.mysql.cj.jdbc.Driver();
//      DriverManager.registerDriver(driver);

      Connection con = DriverManager.getConnection(
              "jdbc:mysql://db-ld2a9-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");

      reviewDao = new ReviewDaoImpl(con);
      bookCaseDao = new BookCaseDaoImpl(con);
      userDao = new UserDaoImpl(con);
      booksInCaseDao = new BooksInCaseDaoImpl(con);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  private void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup reviewMenu = mainMenu.addGroup("독서록");
    reviewMenu.addItem("등록", new ReviewAddHandler(reviewDao, prompt));
    reviewMenu.addItem("조회", new ReviewViewHandler(reviewDao, prompt));
    reviewMenu.addItem("변경", new ReviewModifyHandler(reviewDao, prompt));
    reviewMenu.addItem("삭제", new ReviewDeleteHandler(reviewDao, prompt));
    reviewMenu.addItem("목록", new ReviewListHandler(reviewDao, prompt));


    MenuGroup bookCaseMenu = mainMenu.addGroup("북케이스");
    bookCaseMenu.addItem("등록", new BookCaseAddHandler(bookCaseDao, prompt));

    MenuGroup booksInCaseMenu = bookCaseMenu.addGroup("조회");
    booksInCaseMenu.addItem("등록", new BooksInCaseAddHandler(booksInCaseDao, prompt));
    booksInCaseMenu.addItem("삭제", new BooksInCaseDeleteHandler(booksInCaseDao, prompt));
    booksInCaseMenu.addItem("목록", new BooksInCaseListHandler(booksInCaseDao, bookCaseDao, prompt));

    bookCaseMenu.addItem("변경", new BookCaseModifyHandler(bookCaseDao, prompt));
    bookCaseMenu.addItem("삭제", new BookCaseDeleteHandler(bookCaseDao, prompt));
    bookCaseMenu.addItem("목록", new BookCaseListHandler(bookCaseDao, prompt));
    bookCaseMenu.addItem("북마크", new BookCaseBookmarkHandler(bookCaseDao, prompt));


    MenuGroup userMenu = mainMenu.addGroup("회원");
    userMenu.addItem("등록", new UserAddHandler(userDao, prompt));
    userMenu.addItem("조회", new UserViewHandler(userDao, prompt));
    userMenu.addItem("변경", new UserModifyHandler(userDao, prompt));
    userMenu.addItem("삭제", new UserDeleteHandler(userDao, prompt));
    userMenu.addItem("목록", new UserListHandler(userDao, prompt));
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
  }
}
