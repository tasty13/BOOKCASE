drop table reviews;

drop table bookcases;

drop table books_in_case;

drop table users;

drop table book_boards;



create table reviews(
    review_no int primary key auto_increment,
    book_title varchar(255) not null,
    score int not null,
    comment text null,
    created_date timestamp null default now()
);


create table bookcases(
   bookcase_no int primary key auto_increment,
   case_title varchar(255) not null,
   bookmark boolean not null default false,
   created_date timestamp null default now()
);


create table books_in_case(
    books_in_case_no int primary key auto_increment,
    book_title varchar(255) not null,
    bookcase_no int not null
);

ALTER TABLE books_in_case
  ADD CONSTRAINT FK_bookcases_TO_books_in_case
      FOREIGN KEY (
          bookcase_no
      )
      REFERENCES bookcases (
          bookcase_no
      );


create table users(
  user_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(20) not null,
  nick varchar(50) not null,
  password varchar(255) not null,
  created_date timestamp null default now()
);


create table book_boards(
  board_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  created_date timestamp null default now()
);