package com.bookcase.handler;

import com.bookcase.menu.Menu;
import com.bookcase.menu.MenuHandler;
import com.util.AnsiEscape;

public class ProfileHandler implements MenuHandler {

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    }
}
