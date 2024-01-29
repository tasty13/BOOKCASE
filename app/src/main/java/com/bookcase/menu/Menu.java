package com.bookcase.menu;

import com.util.Prompt;

public interface Menu {

  public abstract void execute(Prompt prompt);

  public abstract String getTitle();
}
