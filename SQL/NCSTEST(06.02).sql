===== 전화번호 부( 테이블 이름 : Contact )

------ 기본정보(not null)
-- 대리키 : 일련번호 -> pIdx 기본키로 설정
-- 이름, 전화번호, 주소, 이메일
-- 주소값과 이메일은 입력이 없을 때 기본값 입력
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능
------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임

create table Contact(
    -- 기본정보
    pIdx number(6), 
    name varchar2(20) CONSTRAINT contact_name_nn not null,
    phonenumber number(20) CONSTRAINT contact_phonenumber_nn not null,
    address varchar2(20) default '기본값' CONSTRAINT contact_adress_nn not null,
    email varchar2(20) default '기본값' CONSTRAINT contact_email_nn not null,
    category varchar2(10),
    -- 대학정보
    major varchar2(20),
    grade number(1),
    -- 회사정보
    company varchar2(20),
    dept varchar2(20),
    job varchar2(20),
    -- 모임정보
    cafename varchar2(20),
    nickname varchar2(20),
    
    constraint contact_pIdx_PK primary key(pIdx),
    constraint contact_category_CK check (category in ('UNIV','COM','CAFE'))
);
select * from dept;

--2. DEPT 테이블에 데이터를 삽입하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.
insert into dept(deptno, dname, loc) values(60, 'production', 'busan');

--3. DEPT 테이블에 위에서 삽입한 데이터의 dname, loc 데이터를 변경하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.
update dept set dname = 'Development', loc = 'seoul' where deptno = 60;

--4. DEPT 테이블에 위에서 삽입한 데이터를 deptno 컬럼의 값을 기반으로 삭제하는 SQL을 작성하시오.
delete from dept where deptno = 60;

--5. 사용자가 보유한 테이블 목록을 확인하는 SQL문을 작성하시오.
select * from user_tables;

--6. EMP 테이블의 구조를 확인하는 SQL을 작성하시오.
desc emp;

--7. 사용자가 정의한 제약조건들을 확인하는 SQL문을 작성하시오.
select * from all_constraints;

--#2 아래 요구사항에 맞도록 고급 SQL 문을 작성하시오.
--1. EMP 테이블의 ename 컬럼에 인덱스를 생성하는 SQL을 작성하시오. 인덱스의 이름은 emp_index
create index emp_index
on emp(ename);

--2. EMP 테이블과 DEPT 테이블을 조인하는 SQL을 기반으로 view 객체를 생성하는 SQL을 작성하시오.
--view 의 이름은 emp_view 로 하시오. 
create or replace view emp_view    
as select ename from emp e, dept d where e.deptno = d.deptno;


--3. EMP 테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호로 변경하는 SQL을 작성하시오.
update emp set deptno = (select deptno from emp where ename = 'SCOTT');


