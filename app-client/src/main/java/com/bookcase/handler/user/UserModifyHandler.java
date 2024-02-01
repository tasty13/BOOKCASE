package com.bookcase.handler.user;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.User;
import com.util.AnsiEscape;
import com.util.Prompt;

public class UserModifyHandler implements MenuHandler {

  UserRepository userRepository;
  Prompt prompt;

  public UserModifyHandler(UserRepository userRepository, Prompt prompt) {
    this.userRepository = userRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = Integer.parseInt(this.prompt.input("번호? "));
    User user = this.userRepository.users[index];
    user.email = this.prompt.input("이메일(%s)? ", user.email);
    user.name = this.prompt.input("이름(%s)? ", user.name);
    user.nick = this.prompt.input("닉네임(%s)? ", user.nick);
    user.password = this.prompt.input("비밀번호(%s)? ", user.password);
  }
}
