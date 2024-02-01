package com.bookcase.handler.user;

import com.bookcase.dao.UserDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.util.Prompt;

public class UserDeleteHandler extends AbstractMenuHandler {

  private UserDao userDao;

  public UserDeleteHandler(UserDao userDao, Prompt prompt) {
    super(prompt);
    this.userDao = userDao;
  }

  @Override
  public void action() {
    int no = this.prompt.inputInt("번호? ");
    if (userDao.delete(no) == 0) {
      System.out.println("유효하지 않은 번호입니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
