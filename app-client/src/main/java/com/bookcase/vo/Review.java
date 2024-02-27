package com.bookcase.vo;

import java.time.LocalDateTime;
import java.util.Date;

public class Review {

    private int no;
    private String bookTitle;
    private int score;
    private String comment;
    private LocalDateTime createdDate;

    @Override
    public String toString() {
        return "Review{" +
            "no=" + no +
            ", bookTitle='" + bookTitle + '\'' +
            ", score=" + score +
            ", comment='" + comment + '\'' +
            ", createdDate=" + createdDate +
            '}';
    }

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
