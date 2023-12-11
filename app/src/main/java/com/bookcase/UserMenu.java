package com.bookcase;

public class UserMenu {

  static User[] users = new User[3];
  static int length;

  static void printMenu() {
    System.out.println("[회원]");
    System.out.println("1. 회원 추가");
    System.out.println("2. 회원 조회");
    System.out.println("3. 회원 변경");
    System.out.println("4. 회원 삭제");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/북케이스> ");
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

  static void add() {
    System.out.println("유저 생성");
    if (length == users.length) {
      System.out.println("더 이상 추가할 수 없습니다.");
    }
    User user = new User();
    user.email = Prompt.input("이메일? ");
    user.name = Prompt.input("이름? ");
    user.nick = Prompt.input("닉네임? ");
    user.password = Prompt.input("비밀번호? ");
    users[length] = user;
    length++;
  }

  static void view() {
    System.out.println("유저 조회");
    for (int i = 0; i < length; i++) {
      User user = users[i];
      System.out.println("이메일: " + user.email);
      System.out.println("이름: " + user.name);
      System.out.println("닉네임: " + user.nick);
      System.out.println("------------------------");
    }

  }

  static void modify() {
    System.out.println("이름 변경");
    int index = Integer.parseInt(Prompt.input("번호? "));
    User user = users[index];
    user.email = Prompt.input("이메일(%s)? ", user.email);
    user.name = Prompt.input("이름(%s)? ", user.name);
    user.nick = Prompt.input("닉네임(%s)? ", user.nick);
    user.password = Prompt.input("비밀번호(%s)? ", user.password);
  }

  static void delete() {
    System.out.println("유저 삭제");
    int index = Integer.parseInt(Prompt.input("번호? "));
    // 1. 배열 한칸씩 땡김
    // 2. length--, 마지막 요소 null
    for (int i = index; i < length - 1; i++) {
      users[i] = users[i + 1];
    }
    length--;
    users[length] = null;
  }
}
