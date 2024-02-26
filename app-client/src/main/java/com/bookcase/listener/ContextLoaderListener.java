package com.bookcase.listener;

import com.bookcase.dao.BookBoardDao;
import com.bookcase.dao.BookCaseDao;
import com.bookcase.dao.InnerBookDao;
import com.bookcase.dao.ReviewDao;
import com.bookcase.dao.UserDao;
import com.bookcase.dao.mysql.BookBoardDaoImpl;
import com.bookcase.dao.mysql.BookCaseDaoImpl;
import com.bookcase.dao.mysql.InnerBookDaoImpl;
import com.bookcase.dao.mysql.ReviewDaoImpl;
import com.bookcase.dao.mysql.UserDaoImpl;
import com.util.DBConnectionPool;
import com.util.TransactionManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  // 웹애플리케이션이 사용할 자원을 준비시키고 해제시키는 역할

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("웹애플리케이션 자원 준비!");

    // DB 커넥션, DAO, 트랜잭션 관리자 생성
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");

    BookBoardDao boardDao = new BookBoardDaoImpl(connectionPool);
    BookCaseDao bookCaseDao = new BookCaseDaoImpl(connectionPool);
    InnerBookDao innerBookDao = new InnerBookDaoImpl(connectionPool);
    ReviewDao reviewDao = new ReviewDaoImpl(connectionPool);
    UserDao userDao = new UserDaoImpl(connectionPool);
    TransactionManager txManager = new TransactionManager(connectionPool);

    // 서블릿에서 사용할 수 있도록 웹애플리케이션 저장소에 보관한다.
    ServletContext 웹애플리케이션저장소 = sce.getServletContext();
    웹애플리케이션저장소.setAttribute("boardDao", boardDao);
    웹애플리케이션저장소.setAttribute("bookCaseDao", bookCaseDao);
    웹애플리케이션저장소.setAttribute("innerBookDao", innerBookDao);
    웹애플리케이션저장소.setAttribute("reviewDao", reviewDao);
    웹애플리케이션저장소.setAttribute("userDao", userDao);
    웹애플리케이션저장소.setAttribute("txManager", txManager);
  }
}
