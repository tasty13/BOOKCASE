package com.bookcase.vo;

import java.util.Date;

public class User {

    private int no;
    private String email;
    private String name;
    private String nick;
    private String password;
    private Date createdDate;


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
