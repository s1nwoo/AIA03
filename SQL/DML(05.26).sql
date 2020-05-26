-- 2020.05.26


-- DML

drop table dept01;

create table dept01
as 
select * from dept where 1<0;
desc dept01;
select * from dept01;

-- 새로운 부서 정보를 입력: 행단위 입력
-- insert into 테이블 이름(입력하고자 하는 컬럼들) values (데이터들)
-- 입력 컬럼의 순서와 입력데이터의 순서는 같아야 한다.

insert into dept01 (deptno, dname, loc) values (10, 'MARKETING', 'SEOULT');
insert into dept01 (deptno, dname, loc) values (20, 'DESIGN', 'BUSAN');
insert into dept01 (loc, deptno, dname) values ('LONDON', 30, 'SALES');
insert into dept01 (deptno, dname) values (40, 'DEV');


create table dept02(
    deptno number(2) not null,
    dname varchar2(20) not null,
    loc varchar2(20) default 'SEOUL'
);

insert into dept02 (deptno, dname) values (10, 'MARKETING');
insert into dept02 (deptno, dname, loc) values (40, 'MARKETING', null);

-- 오류 예시
insert into dept02 (deptno, dname) values (10, 'MARKETING', 'SUWON');
insert into dept02 (deptno, dname, loc) values (10, 'MARKETING');

select * from dept02;

