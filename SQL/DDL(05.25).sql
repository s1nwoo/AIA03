-- 2020.05.25


-- DDL

-- 테이블 생성
-- create table 테이블의 이름 () <- 괄호 안에 컬럼을 정의
-- (컬럼명1 타입(사이즈), 컬럼명2 타입(사이즈), ...)

-- ddl_test라는 이름의 테이블을 생성하자
-- 컬럼1 : 컬럼명:no // 타입:숫자타입 // 사이즈:3
-- 컬럼2 : 컬럼명:name // 타입:가변 문자열 // 사이즈:10
-- 컬럼3 : 컬럼명:birth // 타입:날짜타입 기본값은 현재 날짜 시간

create table ddl_test (
    no number(3),
    name varchar2(10),
    birth date default sysdate
);


desc ddl_test;
select * from tab;
select * from ddl_test;


insert into ddl_test (no, name) VALUES (2, 'scott');


-- emp 테이블 참조
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 emp01 테이블을 생성해보기
desc emp;

create table emp01(
    empno number(4),
    ename varchar(10),
    sal number(7,2)

);

select * from tab;
desc emp01;
select * from emp01;

-- 테이블의 복사 : 서브 쿼리 이용
-- 스키마 복사, 행 복사, 제약조건의 복사는 되지 않는다.
create table emp02 as 
select * from emp;

desc emp02;
select * from emp02;


-- emp 테이블의 empno 와 ename 컬럼만 복사해서 새로운 테이블 emp03을 생성한다
create table emp03 as 
select empno, ename from emp;

select * from emp03;

-- 원하는 행으로(조건) 컬럼만 복사해서 새로운 테이블 emp04를 생성한다.
CREATE TABLE EMP04 
AS SELECT * FROM EMP WHERE DEPTNO=10;

select * from emp04;

-- emp 테이블의 스키마 구조만 복사해서 새로운 테이블 emp05를 생성한다
create table emp05
as select * from emp where 1<0;

select * from emp05;


-- 테이블에 컬럼 추가
-- alter table 테이블 이름 add (컬럼정의)
-- emp01 테이블에 직급(job) 컬럼을 추가하자
select * from emp01;

alter table emp01
add (job varchar2(10));


-- 컬럼 변경
-- alter table 테이블 이름 modify (컬럼정의)
-- 직접 컬럼을 최대 30글자까지 저장할 수 있게 변경
alter table emp01
modify (job varchar2(30));


-- 컬럼삭제
-- alter table 테이블 이름 drop (컬럼정의)
-- emp01 테이블에 직급 컬럼을 삭제하자
alter table emp01
drop (job);


desc dept;
insert into dept values (10, 'test', 'seoul');

drop table emp02;

-- 컬럼의 제약 정의는 컬럼 정의를 하면서 컬럼 옆에 정의
-- 컬럼의 타입을 모두 정의하고, 아래에 제약을 정의하는 방법

create table emp02(
    empno number(4) not null,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);

insert into emp02 values(null, null, 'MANAGER', 10);
insert into emp02 values(1111, null, 'MANAGER', 10);
insert into emp02 values(1111, 'SON', 'MANAGER', 10);
select * from emp02;

drop table emp03;

create table emp03(
    empno number(4) unique not null,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);

desc emp03;

INSERT into emp03 values(1111, 'TEST', 'MANAGER', 10);
INSERT into emp03 values(1111, 'TEST123', 'MANAGER', 20);
INSERT into emp03 values(NULL, 'TEST', 'MANAGER', 10);

SELECT * FROM emp03;


drop table emp04;

CREATE TABLE EMP04( 
EMPNO NUMBER(4) CONSTRAINT EMP04_EMPNO_UK UNIQUE, 
ENAME VARCHAR2(10) CONSTRAINT EMP04_ENAME_NN NOT NULL, 
JOB VARCHAR2(9), 
DEPTNO NUMBER(2) 
);
desc emp04;

INSERT into emp04 values(1111, 'TEST', 'MANAGER', 10);
INSERT into emp04 values(1111, 'TEST123', 'MANAGER', 20);
INSERT into emp04 values(NULL, 'TEST', 'MANAGER', 20);

SELECT * FROM emp04;


DROP TABLE EMP05;

CREATE TABLE EMP05(
EMPNO NUMBER(4) CONSTRAINT EMP05_EMPNO_PK PRIMARY KEY ,
ENAME VARCHAR2(10) CONSTRAINT EMP05_ENAME_NN NOT NULL,
JOB VARCHAR2(9),
DEPTNO NUMBER(2)
);

INSERT into emp05 values(1111, 'TEST', 'MANAGER', 10);
INSERT into emp05 values(1111, 'TEST123', 'MANAGER', 20);
INSERT into emp05 values(NULL, 'TEST', 'MANAGER', 20);

SELECT * FROM emp05;


-- 
CREATE TABLE EMP06(
EMPNO NUMBER(4) CONSTRAINT EMP06_EMPNO_PK PRIMARY KEY ,
ENAME VARCHAR2(10) CONSTRAINT EMP06_ENAME_NN NOT NULL,
JOB VARCHAR2(10),
DEPTNO NUMBER(2) CONSTRAINT EMP06_DEPTNO_FK REFERENCES DEPT(DEPTNO)
);

DESC EMP06;
INSERT into emp06 values(1111, 'TEST', 'MANAGER', 10);
INSERT into emp06 values(1111, 'TEST123', 'MANAGER', 20);
INSERT into emp06 values(NULL, 'TEST123', 'MANAGER', 20);
INSERT into emp06 values(2222, 'TEST123', 'MANAGER', 50);

SELECT * FROM EMP06;


create table emp07(
    EMPNO NUMBER(4) CONSTRAINT EMP07_EMPNO_PK PRIMARY KEY ,
    ENAME VARCHAR2(10) CONSTRAINT EMP07_ENAME_NN NOT NULL,
    JOB VARCHAR2(10) DEFAULT 'MANAGER',
    DEPTNO NUMBER(2) CONSTRAINT EMP07_DEPTNO_FK REFERENCES DEPT(DEPTNO),
    GENDER CHAR(1) CONSTRAINT EMP07_GENDER_CK CHECK (GENDER='M' OR GENDER='F'),
    SAL NUMBER(7,2) CONSTRAINT EMP07_SAL_CK CHECK (SAL BETWEEN 500 AND 5000),
    BIRTHDAY DATE DEFAULT SYSDATE
);

DESC EMP07;
INSERT into emp07 values(1111, 'TEST', 'MANAGER', 10, 'F', 3000, '');
INSERT into emp07 values(1112, 'TEST', NULL, 10, 'M', 5000, NULL);

SELECT * FROM EMP07;

