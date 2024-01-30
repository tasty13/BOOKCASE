package com.bookcase.handler.user;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.bookcase.vo.User;
import com.util.AnsiEscape;
import com.util.Prompt;

public class UserListHandler implements MenuHandler {

  UserRepository userRepository;

  public UserListHandler(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    System.out.printf("%-10s\t%30s\t%s\n", "닉네임", "이메일", "가입 날짜");

    for (int i = 0; i < this.userRepository.length; i++) {
      User member = this.userRepository.users[i];
      System.out.printf("%-10s\t%30s\t%3$tY-%3$tm-%3$td\n",
              member.nick, member.email, member.createdDate);
    }
  }
}
