package com.bookcase;

public class BookCaseMenu {

    static BookCase[] bookCases = new BookCase[3];
    static int length;

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
        System.out.println("북케이스 생성");
        if (length == bookCases.length) {
            // 1. 새사이즈 배열 만듦
            // 2. 새 배열에 원래 배열 요소 넣어줌
            // 3. 북케이스 변수에 새 배열 주소 저장
            int oldSize = bookCases.length;
            int newSize = oldSize + oldSize / 2;
            BookCase[] temp = new BookCase[newSize];
            for (int i = 0; i < oldSize; i++) {
                temp[i] = bookCases[i];
            }
            bookCases = temp;
        }

        BookCase bookCase = new BookCase();
        bookCase.caseTitle = Prompt.input("북케이스 이름? ");

        bookCases[length] = bookCase;
        length++;
    }
    static void view(){
        System.out.println("북케이스 조회");
        for (int i=0;i<length;i++){
            BookCase bookCase = bookCases[i];
            System.out.println("북케이스 이름: " + bookCase.caseTitle);
            System.out.println("--------------------------");
        }
    }
    static void modify(){
        System.out.println("북케이스 이름 변경");
        int index = Integer.parseInt(Prompt.input("번호? "));
        BookCase bookCase = bookCases[index];
        bookCase.caseTitle = Prompt.input("북케이스 이름(%s)? ", bookCase.caseTitle);
    }
    static void delete(){
        System.out.println("북케이스 삭제");
        int index = Integer.parseInt(Prompt.input("번호? "));
        // 1. 배열 인덱스기준으로 한칸씩 앞으로 땡김
        // 2. length 하나 줄임, 배열 마지막값 null
        for (int i = index; i < length - 1; i++) {
            bookCases[i] = bookCases[i + 1];
        }
        length--;
        bookCases[length] = null;
    }
}
