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
--comment_no, mem_id, post_no, content, write_date

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

CREATE SEQUENCE board_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

insert into board (post_no, mem_id, title, content)
values(board_seq.nextval,'ab12','test','~~~~~~~~~~~~~~~~');

insert into board (post_no, mem_id, title, content)
values(board_seq.nextval,'ab12','test2222','%%%%%%%%%');

insert into board (post_no, mem_id, title, content)
values(board_seq.nextval,'ab12','test3333','dfsdfsdfs');

update board set title = 'testMod' where mem_id='ab12' and post_no=1;

update board 
set title = 'testmod23',
content = 'tecon34' 
where mem_id='ab12' and post_no=1;
--post_no, mem_id, title, content, write_date
select b.post_no, 
       b.mem_id, 
       b.title, 
       b.content, 
       count(c.comment_no) as 댓글수, 
       b.write_date 
from board b left join reply c on b.post_no = c.post_no
group by b.post_no, 
       b.mem_id, 
       b.title, 
       b.content,
       b.write_date
order by post_no;


CREATE SEQUENCE reply_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

insert into reply(comment_no,mem_id,post_no,content)
values (reply_seq.nextval,'ab12',1,'ssssss');
insert into reply(comment_no,mem_id,post_no,content)
values (reply_seq.nextval,'ab12',1,'ffffff');
 --게시글 // 게시글 번호, 작성자 id, 제목, 내용, 작성일자
--post_no, mem_id, title, content, write_date
--댓글 // 작성자 id, 게시글 번호, 댓글번호, 댓글내용, 작성일자
--comment_no, mem_id, post_no, content, write_date

-- 가져올 내용
 -- 글제목, 글 작성자, 글내용, 글 작성일자, 
 -- 댓글 작성자, 댓글 내용, 댓글 작성일자
select b.title, b.mem_id , b.content, b.write_date , c.mem_id, c.content, c.write_date
from board b left join reply c on b.post_no = c.post_no
where c.post_no is not null
and b.mem_id = 'ab12'
and b.post_no = 1
order by c.write_date;

select * from board;

insert into member 
values('te12','1234','권준오','bbb@email.com');
insert into member 
values('jh12','1234','김진형','bbb@email.com');