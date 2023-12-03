package com.bookcase;

public class App {

  // 애플리케이션 객체 App 실행할 떄 다음 변수를 미리 준비해 둔다.
  // -> 속도 빨라짐!
  public static void main(String[] args) {
    MainMenu.execute();
    Prompt.close(); // Prompt쪽에서 keyIn 자원해제(close)시키도록 함. (참견X)
  }
}
