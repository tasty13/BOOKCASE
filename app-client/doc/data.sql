-- reviews 테이블 데이터 --
insert into reviews(book_title,score,comment) values('책제목1',5,'후기1');
insert into reviews(book_title,score,comment) values('책제목2',2,'후기2');
insert into reviews(book_title,score,comment) values('책제목3',3,'후기3');
insert into reviews(book_title,score,comment) values('책제목4',1,'후기4');
insert into reviews(book_title,score,comment) values('책제목5',4,'후기5');

-- bookcases 테이블 데이터 --
insert into bookcases(case_title) values('내 북케이스1');
insert into bookcases(case_title) values('내 북케이스2');
insert into bookcases(case_title) values('내 북케이스3');
insert into bookcases(case_title) values('내 북케이스4');
insert into bookcases(case_title) values('내 북케이스5');

-- books_in_case 테이블 데이터 --
insert into books_in_case(book_title, bookcase_no) values('책이름1',1);
insert into books_in_case(book_title, bookcase_no) values('책이름2',1);
insert into books_in_case(book_title, bookcase_no) values('책이름3',2);
insert into books_in_case(book_title, bookcase_no) values('책이름4',4);
insert into books_in_case(book_title, bookcase_no) values('책이름5',5);

-- users 테이블 데이터 --
insert into users(email, name, nick, password) values('user1@test.com','이름1','닉네임1',sha2('password1', 256));
insert into users(email, name, nick, password) values('user2@test.com','이름2','닉네임2',sha2('password2', 256));
insert into users(email, name, nick, password) values('user3@test.com','이름3','닉네임3',sha2('password3', 256));
insert into users(email, name, nick, password) values('user4@test.com','이름4','닉네임4',sha2('password4', 256));
insert into users(email, name, nick, password) values('user5@test.com','이름5','닉네임5',sha2('password5', 256));

-- book_boards 테이블 데이터 --
insert into book_boards(title,content,writer) values('제목1','내용1','이름1');
insert into book_boards(title,content,writer) values('제목2','내용2','이름2');
insert into book_boards(title,content,writer) values('제목3','내용3','이름3');
insert into book_boards(title,content,writer) values('제목4','내용4','이름4');
insert into book_boards(title,content,writer) values('제목5','내용5','이름5');

