package com.bookcase;

public class BookCaseMenu {
    static void execute() {
        printMenu();

        while (true) {
            String input = Prompt.input("메인/북케이스");
            switch (input) {
                case "1":
                    System.out.println("생성");
                    break;
                case "2":
                    System.out.println("조회");
                    break;
                case "3":
                    System.out.println("이름 변경");
                    break;
                case "4":
                    System.out.println("삭제");
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

    static void printMenu() {
        System.out.println("[북케이스]");
        System.out.println("1. 생성");
        System.out.println("2. 조회");
        System.out.println("3. 이름 변경");
        System.out.println("4. 삭제");
        System.out.println("0. 이전");
    }
}
