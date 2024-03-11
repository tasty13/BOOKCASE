package com.bookcase.handler.user;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.User;
import com.util.AnsiEscape;
import com.util.Prompt;

import java.util.Date;

public class UserAddHandler implements MenuHandler {

  UserRepository userRepository;
  Prompt prompt;

  public UserAddHandler(UserRepository userRepository, Prompt prompt) {
    this.userRepository = userRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    if (this.userRepository.length == this.userRepository.users.length) {
      System.out.println("더 이상 추가할 수 없습니다.");
    }
    User user = new User();
    user.email = this.prompt.input("이메일? ");
    user.name = this.prompt.input("이름? ");
    user.nick = this.prompt.input("닉네임? ");
    user.password = this.prompt.input("비밀번호? ");
    user.createdDate = new Date();
    this.userRepository.users[this.userRepository.length++] = user;
  }
}
