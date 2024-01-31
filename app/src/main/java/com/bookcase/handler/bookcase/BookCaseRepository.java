package com.bookcase.handler.bookcase;

import com.bookcase.vo.BookCase;
import com.bookcase.vo.Review;

public class BookCaseRepository {
    BookCase[] bookCases = new BookCase[3];
    int length = 0;

    public void add(BookCase bookCase){
        if (this.length == this.bookCases.length) {
            // 1. 새사이즈 배열 만듦
            // 2. 새 배열에 원래 배열 요소 넣어줌
            // 3. 북케이스 변수에 새 배열 주소 저장
            int oldSize = this.bookCases.length;
            int newSize = oldSize + oldSize / 2;
            BookCase[] arr = new BookCase[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = this.bookCases[i];
            }
            this.bookCases = arr;
        }
        this.bookCases[this.length++] = bookCase;
    }

    public BookCase remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }

        BookCase deleted = bookCases[index];

        // 1. 배열 인덱스기준으로 한칸씩 앞으로 땡김
        // 2. length 하나 줄임, 배열 마지막값 null
        for (int i = index; i < this.length - 1; i++) {
            this.bookCases[i] = this.bookCases[i + 1];
        }
        this.bookCases[--this.length] = null;

        return deleted;
    }

    public BookCase[] toArray(){
        BookCase[] arr = new BookCase[this.length];
        for (int i = 0; i < this.length; i++) {
            arr[i] = bookCases[i];
        }
        return arr;
    }

    public BookCase get(int index){
        if (index < 0 || index >= this.length) {
            return null;
        }
        return bookCases[index];
    }

    public BookCase set(int index, BookCase bookCase) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        BookCase old = this.get(index);
        this.bookCases[index] = bookCase;

        return old;
    }
}
