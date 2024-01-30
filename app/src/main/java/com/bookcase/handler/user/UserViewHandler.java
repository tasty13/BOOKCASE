package com.bookcase.handler.user;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.User;
import com.util.AnsiEscape;
import com.util.Prompt;

public class UserViewHandler implements MenuHandler {

  UserRepository userRepository;
  Prompt prompt;

  public UserViewHandler(UserRepository userRepository, Prompt prompt) {
    this.userRepository = userRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.userRepository.length) {
      System.out.println("유효하지 않은 번호입니다.");
      return;
    }

    User user = this.userRepository.users[index];
    System.out.println("이메일: " + user.email);
    System.out.println("이름: " + user.name);
    System.out.println("닉네임: " + user.nick);
    System.out.println("가입 날짜: " + user.createdDate);
  }
}
