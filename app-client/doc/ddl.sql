drop table reviews;

create table reviews(
    review_no int primary key auto_increment,
    book_title varchar(255) not null,
    score int not null,
    comment text null,
    created_date timestamp null default now()
);

insert into reviews(book_title,score,comment) values('책제목1',5,'후기1');
insert into reviews(book_title,score,comment) values('책제목2',2,'후기2');
insert into reviews(book_title,score,comment) values('책제목3',3,'후기3');
insert into reviews(book_title,score,comment) values('책제목4',1,'후기4');
insert into reviews(book_title,score,comment) values('책제목5',4,'후기5');

select * from reviews where review_no=2;

select * from reviews;

update reviews set score=4, comment='바뀐후기2' where review_no=2;

delete from reviews where review_no=2;



drop table bookcases;

create table bookcases(
   bookcase_no int primary key auto_increment,
   case_title varchar(255) not null,
   bookmark boolean not null default false,
   created_date timestamp null default now()
);

insert into bookcases(case_title) values('내 북케이스1');
insert into bookcases(case_title) values('내 북케이스2');
insert into bookcases(case_title) values('내 북케이스3');
insert into bookcases(case_title) values('내 북케이스4');
insert into bookcases(case_title) values('내 북케이스5');

select * from bookcases where bookcase_no=3;

select * from bookcases;

update bookcases set case_title='바뀐북케이스이름3' where bookcase_no=3;

update bookcases set bookmark=true where bookcase_no=3;

delete from bookcases where bookcase_no=3;



drop table books_in_case;

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

insert into books_in_case(book_title, bookcase_no) values('책이름1',1);
insert into books_in_case(book_title, bookcase_no) values('책이름2',1);
insert into books_in_case(book_title, bookcase_no) values('책이름3',2);
insert into books_in_case(book_title, bookcase_no) values('책이름4',4);
insert into books_in_case(book_title, bookcase_no) values('책이름5',4);

select * from books_in_case where bookcase_no=1;

delete from books_in_case where books_in_case_no=3;



drop table users;

create table users(
  user_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(20) not null,
  nick varchar(50) not null,
  password varchar(255) not null,
  created_date timestamp null default now()
);

insert into users(email, name, nick, password) values('user1@test.com','이름1','닉네임1',sha2('password1', 256));
insert into users(email, name, nick, password) values('user2@test.com','이름2','닉네임2',sha2('password2', 256));
insert into users(email, name, nick, password) values('user3@test.com','이름3','닉네임3',sha2('password3', 256));
insert into users(email, name, nick, password) values('user4@test.com','이름4','닉네임4',sha2('password4', 256));
insert into users(email, name, nick, password) values('user5@test.com','이름5','닉네임5',sha2('password5', 256));

select * from users where user_no=4;

select * from users;

update users
    set email='바뀐이메일주소4',name='바뀐이름4',nick='바뀐닉네임4',password=sha2('바뀐비밀번호4',256)
    where user_no=4;

delete from users where user_no=4;


