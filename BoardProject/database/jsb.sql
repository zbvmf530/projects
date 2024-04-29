--ȸ��
--mem_id, mem_pw, name, email
create table member
(   
    mem_id    VARCHAR2(50 CHAR)      primary key,
    mem_pw    VARCHAR2(50 CHAR),
    name      VARCHAR2(50 CHAR),
    email     VARCHAR2(50 CHAR)
);

--�Խñ� // �Խñ� ��ȣ, �ۼ��� id, ����, ����, �ۼ�����
--post_no, mem_id, title, content, write_date
create table board
(   
    post_no      NUMBER      primary key,
    mem_id       VARCHAR2(50 CHAR),
    title        VARCHAR2(300 CHAR),
    content      VARCHAR2(300 CHAR),
    write_date   date default sysdate
);


--��� // �ۼ��� id, �Խñ� ��ȣ, ��۹�ȣ, ��۳���, �ۼ�����
--comment_no, mem_id, post_no, content, write_date
create table reply
(   
    comment_no   NUMBER primary key,
    mem_id       VARCHAR2(50 CHAR),
    post_no      NUMBER,
    content      VARCHAR2(300 CHAR),
    write_date   date default sysdate
);


-- �Խñ�, ��� ������ 
CREATE SEQUENCE board_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

CREATE SEQUENCE reply_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;