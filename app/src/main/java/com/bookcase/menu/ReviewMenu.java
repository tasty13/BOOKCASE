package com.bookcase.menu;

import com.bookcase.vo.BookCase;
import com.util.Prompt;
import com.bookcase.vo.Review;

public class ReviewMenu {

  Prompt prompt;
  String title;
  Review[] reviews = new Review[3];
  int length;

  public ReviewMenu(Prompt prompt, String title) {
    this.prompt = prompt;
    this.title = title;
  }

  public void printMenu() {
    System.out.println("[독서록]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  public void execute() {
    printMenu();

    while (true) {
      String input = this.prompt.input("메인/독서록> ");
      switch (input) {
        case "1":
          this.add();
          break;
        case "2":
          this.view();
          break;
        case "3":
          this.modify();
          break;
        case "4":
          this.delete();
          break;
        case "5":
          this.list();
          break;
        case "0":
          return;
        case "menu":
          this.printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
          break;
      }
    }
  }
  public void add(){
    System.out.println("등록");

    if (length == reviews.length){
      // 1. 새 사이즈 배열 만듦
      // 2. 원래 배열 요소들 새 배열에 넣어줌
      // 3. reviews 변수에 새 배열 주소 저장해줌
      int oldSize = reviews.length;
      int newSize = oldSize + oldSize / 2;
      Review[] temp = new Review[newSize];
      for (int i = 0; i < oldSize; i++) {
        temp[i] = reviews[i];
      }
      reviews = temp;

    }
    Review review = new Review();
    review.bookTitle = this.prompt.input("책 이름? ");
    review.grade = this.prompt.input("책 별점? ");
    review.comment = this.prompt.input("책 후기? ");

    reviews[length] = review;
    length++;
  }

  void list(){
    System.out.printf("%-20s\t%s\t%-30s\n", "책 제목", "별점", "후기");
    for (int i = 0; i < this.length; i++) {
      Review review = this.reviews[i];
      System.out.printf("%-20s\t%s\t%-30s\n", review.bookTitle, review.grade, review.comment);
    }
  }

  public void view(){
    System.out.println("조회");
    for (int i=0;i<length;i++){
      Review review = reviews[i];
      System.out.println("책 이름: " + review.bookTitle);
      System.out.println("책 별점: " + review.grade);
      System.out.println("책 후기: " + review.comment);
      System.out.println("--------------------------------");
    }

  }
  public void modify(){
    System.out.println("변경");
    int index = Integer.parseInt(this.prompt.input("번호: "));
    Review review = reviews[index];
    review.bookTitle = this.prompt.input("책 이름(%s)? ", review.bookTitle);
    review.grade = this.prompt.input("책 별점(%s)? ", review.grade);
    review.comment = this.prompt.input("책 후기(%s)? ", review.comment);
  }
  public void delete(){
    System.out.println("삭제");
    // 배열 앞쪽으로 하나씩 당김
    // length 하나 줄여줌, 마지막 요소 null로 만듦
    int index = Integer.parseInt(this.prompt.input("번호: "));
    for (int i = index; i<length-1; i++){
      reviews[i] = reviews[i + 1];
    }
    length--;
    reviews[length] = null;
  }
}
