package com.bookcase.enums;

public enum BookBoardStatus {

  READY(0),
  PROGRESS(1),
  FINISH(2),
  ;

  BookBoardStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  private final int code;
}
