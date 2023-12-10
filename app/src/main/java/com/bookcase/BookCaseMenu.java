package com.bookcase;

public class BookCaseMenu {

    static BookCase bookCase = new BookCase();

    static void printMenu() {
        System.out.println("[북케이스]");
        System.out.println("1. 생성");
        System.out.println("2. 조회");
        System.out.println("3. 이름 변경");
        System.out.println("4. 삭제");
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
        bookCase.caseTitle = Prompt.input("북케이스 이름? ");
    }
    static void view(){
        System.out.println("조회");
        System.out.println("북케이스 이름: " + bookCase.caseTitle);
    }
    static void modify(){
        System.out.println("이름 변경");
        bookCase.caseTitle = Prompt.input("북케이스 이름(%s)? ", bookCase.caseTitle);
    }
    static void delete(){
        bookCase.caseTitle = "";
    }
}
