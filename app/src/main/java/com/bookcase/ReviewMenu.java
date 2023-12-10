package com.bookcase;

public class ReviewMenu {

  static Review[] reviews = new Review[3];
  static int length;

  static void printMenu() {
    System.out.println("[독서록]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/독서록> ");
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
    System.out.println("등록");

    Review review = new Review();
    review.bookTitle = Prompt.input("책 이름? ");
    review.grade = Prompt.input("책 별점? ");
    review.comment = Prompt.input("책 후기? ");

    reviews[length] = review;
    length++;
  }
  static void view(){
    System.out.println("조회");
    for (int i=0;i<length;i++){
      Review review = reviews[i];
      System.out.println("책 이름: " + review.bookTitle);
      System.out.println("책 별점: " + review.grade);
      System.out.println("책 후기: " + review.comment);
    }

  }
  static void modify(){
    System.out.println("변경");
    int index = Integer.parseInt(Prompt.input("번호: "));
    Review review = reviews[index];
    review.bookTitle = Prompt.input("책 이름(%s)? ", review.bookTitle);
    review.grade = Prompt.input("책 별점(%s)? ", review.grade);
    review.comment = Prompt.input("책 후기(%s)? ", review.comment);
  }
  static void delete(){
    System.out.println("삭제");
//    review.bookTitle = "";
//    review.grade = "";
//    review.comment = "";
  }
}
