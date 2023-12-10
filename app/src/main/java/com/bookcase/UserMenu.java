package com.bookcase;

public class UserMenu {

    static User user = new User();

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
    static void add(){
        System.out.println("생성");
        user.email = Prompt.input("이메일? ");
        user.name = Prompt.input("이름? ");
        user.nick = Prompt.input("닉네임? ");
        user.password = Prompt.input("비밀번호? ");
    }
    static void view(){
        System.out.println("조회");
        System.out.println("이메일: " + user.email);
        System.out.println("이름: " + user.name);
        System.out.println("닉네임: " + user.nick);
    }
    static void modify(){
        System.out.println("이름 변경");
        user.email = Prompt.input("이메일(%s)? ", user.email);
        user.name = Prompt.input("이름(%s)? ", user.name);
        user.nick = Prompt.input("닉네임(%s)? ", user.nick);
        user.password = Prompt.input("비밀번호(%s)? ", user.password);
    }
    static void delete(){
        user.email = "";
        user.name = "";
        user.nick = "";
        user.password = "";
    }
}
