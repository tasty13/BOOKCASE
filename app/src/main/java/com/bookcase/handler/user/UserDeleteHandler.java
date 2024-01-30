package com.bookcase.handler.user;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.util.AnsiEscape;
import com.util.Prompt;

public class UserDeleteHandler implements MenuHandler {

  UserRepository userRepository;
  Prompt prompt;

  public UserDeleteHandler(UserRepository userRepository, Prompt prompt) {
    this.userRepository = userRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = Integer.parseInt(this.prompt.input("번호? "));
    // 1. 배열 한칸씩 땡김
    // 2. length--, 마지막 요소 null
    for (int i = index; i < this.userRepository.length - 1; i++) {
      this.userRepository.users[i] = this.userRepository.users[i + 1];
    }
    this.userRepository.users[--this.userRepository.length] = null;
  }
}
