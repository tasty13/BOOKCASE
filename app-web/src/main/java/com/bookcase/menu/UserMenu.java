package com.bookcase.menu;

import com.util.Prompt;
import com.bookcase.vo.User;
import java.util.Date;

public class UserMenu implements Menu {

  Prompt prompt;
  String title;
  User[] users = new User[3];
  int length;

  public UserMenu(Prompt prompt, String title) {
    this.prompt = prompt;
    this.title = title;
  }

  public void printMenu() {
    System.out.printf("[%s]\n", this.title);
    System.out.println("1. 회원 추가");
    System.out.println("2. 회원 조회");
    System.out.println("3. 회원 변경");
    System.out.println("4. 회원 삭제");
    System.out.println("5. 회원 목록");
    System.out.println("0. 이전");
  }

  public void execute() {
    printMenu();

    while (true) {
      String input = this.prompt.input("메인/%s> ", this.title);
      switch (input) {
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          list();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
          break;
      }
    }
  }

  @Override
  public void execute(Prompt prompt) {

  }

  @Override
  public String getTitle() {
    return null;
  }

  void add() {
    System.out.println("유저 생성");
    if (this.length == this.users.length) {
      System.out.println("더 이상 추가할 수 없습니다.");
    }
    User user = new User();
    user.email = this.prompt.input("이메일? ");
    user.name = this.prompt.input("이름? ");
    user.nick = this.prompt.input("닉네임? ");
    user.password = this.prompt.input("비밀번호? ");
    user.createdAt = new Date();
    this.users[this.length++] = user;
  }

  void list() {
    System.out.println("회원 목록:");
    System.out.printf("%-10s\t%30s\t%s\n", "닉네임", "이메일", "가입 날짜");

    for (int i = 0; i < this.length; i++) {
      User member = this.users[i];
      System.out.printf("%-10s\t%30s\t%3$tY-%3$tm-%3$td\n",
          member.nick, member.email, member.createdAt);
    }
  }

  void view() {
    System.out.println("유저 조회");
    for (int i = 0; i < this.length; i++) {
      User user = this.users[i];
      System.out.println("이메일: " + user.email);
      System.out.println("이름: " + user.name);
      System.out.println("닉네임: " + user.nick);
      System.out.println("가입 날짜: " + user.createdAt);
      System.out.println("------------------------");
    }

  }

  void modify() {
    System.out.println("이름 변경");
    int index = Integer.parseInt(this.prompt.input("번호? "));
    User user = this.users[index];
    user.email = this.prompt.input("이메일(%s)? ", user.email);
    user.name = this.prompt.input("이름(%s)? ", user.name);
    user.nick = this.prompt.input("닉네임(%s)? ", user.nick);
    user.password = this.prompt.input("비밀번호(%s)? ", user.password);
  }

  void delete() {
    System.out.println("유저 삭제");
    int index = Integer.parseInt(this.prompt.input("번호? "));
    // 1. 배열 한칸씩 땡김
    // 2. length--, 마지막 요소 null
    for (int i = index; i < this.length - 1; i++) {
      this.users[i] = this.users[i + 1];
    }
    this.users[--this.length] = null;
  }
}
