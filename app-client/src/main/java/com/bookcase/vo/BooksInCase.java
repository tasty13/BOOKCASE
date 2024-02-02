package com.bookcase.vo;

import java.util.Date;

public class BooksInCase {
  private int no;
  private String bookTitle;
  private int bookCaseNo;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public int getBookCaseNo() {
    return bookCaseNo;
  }

  public void setBookCaseNo(int bookCaseNo) {
    this.bookCaseNo = bookCaseNo;
  }
}
