package com.bookcase.handler.user;

import com.bookcase.dao.UserDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.User;
import com.util.AnsiEscape;
import com.util.Prompt;

import java.util.ArrayList;
import java.util.List;

public class UserListHandler extends AbstractMenuHandler {

  private UserDao userDao;

  public UserListHandler(UserDao userDao, Prompt prompt) {
    super(prompt);
    this.userDao = userDao;
  }

  @Override
  public void action() {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    System.out.printf("%-4s\t%-10s\t%30s\t%s\n", "번호", "닉네임", "이메일", "가입 날짜");
    List<User> list = userDao.findAll();

    for (User user : list){
      System.out.printf("%-4d\t%-10s\t%30s\t%4$tY-%4$tm-%4$td\n",
              user.getNo(), user.getNick(), user.getEmail(), user.getCreatedDate());
    }
  }
}
