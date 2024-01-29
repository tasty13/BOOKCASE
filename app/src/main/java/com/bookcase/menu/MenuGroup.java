package com.bookcase.menu;

public class MenuGroup implements Menu{

  String title;
  Menu[] menus = new Menu[10];
  int menuSize;

  public MenuGroup(String title) {
    this.title = title;
  }

  @Override
  public void execute() {
    // TODO
  }

  public void printMenu() {
    System.out.printf("[%s]\n", this.title);

    for(int i=0;i<menuSize;i++){
      System.out.printf("%d. %s\n", (i + 1), menus[i].getTitle());
    }
    System.out.printf("0. %s\n", "이전");
  }

  @Override
  public String getTitle() {
    return null;
  }

  public void add(){
    // TODO
  }
  public void delete(){
    // TODO
  }
}
