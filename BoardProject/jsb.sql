--회원
--mem_id, mem_pw, name, email
create table member
(   
    mem_id    VARCHAR2(15)      primary key,
    mem_pw    VARCHAR2(15),
    name      VARCHAR2(10),
    email     VARCHAR2(100)
);

--게시글 // 게시글 번호, 작성자 id, 제목, 내용, 작성일자
--post_no, mem_id, title, content, write_date
create table board
(   
    post_no      NUMBER      primary key,
    mem_id       VARCHAR2(15),
    title        VARCHAR2(10),
    content      VARCHAR2(100),
    write_date   date default sysdate
);


--댓글 // 작성자 id, 게시글 번호, 댓글번호, 댓글내용, 작성일자
--comment_no, mem_id, post_no, comment_content, write_date

create table reply
(   
    comment_no   NUMBER primary key,
    mem_id       VARCHAR2(15),
    post_no      NUMBER,
    content      VARCHAR2(100),
    write_date   date default sysdate
);

ALTER USER jsb DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

insert into reply(comment_no,mem_id,post_no,content)
values (1,'ab12',1,'dsfsd');
-- mem_id, mem_pw, name, email
insert into member 
values('ab12','1234','정수범','abc@email.com');