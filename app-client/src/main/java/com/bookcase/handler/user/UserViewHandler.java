package com.bookcase.handler.user;

import com.bookcase.dao.UserDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.Review;
import com.bookcase.vo.User;
import com.util.AnsiEscape;
import com.util.Prompt;

public class UserViewHandler extends AbstractMenuHandler {

  private UserDao userDao;

  public UserViewHandler(UserDao userDao, Prompt prompt) {
    super(prompt);
    this.userDao = userDao;
  }

  @Override
  public void action() {
    int no = this.prompt.inputInt("번호? ");
    User user = userDao.findBy(no);
    if (user == null) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    System.out.printf("이메일: %s\n", user.getEmail());
    System.out.printf("이름: %s\n", user.getName());
    System.out.printf("닉네임: %s\n", user.getNick());
    System.out.printf("가입 날짜: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n",user.getCreatedDate());
  }
}
