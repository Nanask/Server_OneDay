CREATE TABLE tbl_ToDoList (
    td_seq	NUMBER		PRIMARY KEY,
    td_date	VARCHAR2(10)	NOT NULL,	
    td_time	VARCHAR2(10)	NOT NULL,	
    td_writer	nVARCHAR2(250)	NOT NULL,
    td_place	nVARCHAR2(50)	NOT NULL	

);

DROP TABLE tbl_ToDoList;

CREATE SEQUENCE seq_ToDoList
START WITH 1 INCREMENT BY 1;

drop sequence seq_ToDoList;

CREATE VIEW view_목록 AS
(SELECT td_seq 글번호, 
    td_date 작성일자,
    td_time 작성시간,
    td_writer 글내용,
    td_place 장소
    FROM tbl_ToDoList
    
);

DROP VIEW view_목록;
DROP TABLE tbl_ToDoList;

INSERT INTO tbl_todolist(td_seq, td_date, td_time, td_writer, td_place)
VALUES(SEQ_TODOLIST.nextval,"2021-05-24","12:00","밥을 먹었다","학원");

INSERT INTO tbl_todolist(td_seq, td_date, td_time, td_writer, td_place)
VALUES(SEQ_TODOLIST.nextval,'2021-05-25','12:00','밥을 먹었다','학원');

DELETE FROM tbl_todolist;

commit;





