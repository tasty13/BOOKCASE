package com.bookcase.handler.user;

import com.bookcase.dao.UserDao;
import com.bookcase.menu.AbstractMenuHandler;
import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.Review;
import com.bookcase.vo.User;
import com.util.AnsiEscape;
import com.util.Prompt;

public class UserModifyHandler extends AbstractMenuHandler {

  private UserDao userDao;

  public UserModifyHandler(UserDao userDao, Prompt prompt) {
    super(prompt);
    this.userDao = userDao;
  }

  @Override
  public void action() {
    int no = this.prompt.inputInt("번호? ");
    User old = userDao.findBy(no);
    if (old == null) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    User user = new User();
    user.setEmail(this.prompt.input("이메일(%s)? ", old.getEmail()));
    user.setName(this.prompt.input("이름(%s)? ", old.getName()));
    user.setNick(this.prompt.input("닉네임(%s)? ", old.getNick()));
    user.setPassword(this.prompt.input("비밀번호(%s)? ", old.getPassword()));
    user.setCreatedDate(old.getCreatedDate());

    userDao.update(user);
    System.out.println("변경사항을 저장했습니다.");
  }
}
