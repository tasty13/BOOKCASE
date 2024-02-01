package com.bookcase.handler.user;

import com.bookcase.dao.UserDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.vo.User;
import com.util.Prompt;

import java.util.Date;

public class UserAddHandler extends AbstractMenuHandler {

  private UserDao userDao;
  public UserAddHandler(UserDao userDao, Prompt prompt) {
    super(prompt);
    this.userDao = userDao;
  }

  @Override
  public void action() {
    try {
      User user = new User();
      user.setEmail(this.prompt.input("이메일? "));
      user.setName(this.prompt.input("이름? "));
      user.setNick(this.prompt.input("닉네임? "));
      user.setPassword(this.prompt.input("비밀번호? "));
      user.setCreatedDate(new Date());

      this.userDao.add(user);

    } catch (Exception e) {
      System.out.println("입력 중 오류 발생!");
      System.out.println("다시 시도해 주세요.");
    }
  }
}
