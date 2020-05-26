-- 2020.05.26

-- 전화번호 관리 프로그램


-- [기본정보] 이름 / 전화번호 / 생일 / 이메일
-- [대학교] 전공 / 학년
-- [회사] 부서이름 / 직급
-- [카페] 모임이름 / 닉네임

-- 대리키 : 일련번호 - p_idx

create table contact(
    -- 기본정보
    pIdx number(6), 
    name varchar2(20) CONSTRAINT contact_name_nn not null,
    phonenumber number(20) CONSTRAINT contact_phonenumber_nn not null,
    address varchar2(20) default '입력 없음' CONSTRAINT contact_adress_nn not null,
    email varchar2(20) default '입력 없음' CONSTRAINT contact_email_nn not null,
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

drop table phoneinfo_basic;
drop table phoneinfo_univ;
drop table phoneinfo_com;

create table phoneInfo_basic(
    idx number(6),
    fr_name varchar2(20) constraint phoneInfo_basic_fr_name_nn not null,
    fr_phonenum varchar2(20) constraint phoneInfo_basic_fr_phonenum_nn not null,
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_regdate date default sysdate,
    
    constraint phoneInfo_basic_idx_pk primary key(idx)
);


create table phoneInfo_univ(
    idx number(6),
    fr_u_major varchar2(20) default 'N' constraint phoneInfo_univ_fr_u_magor_nn not null,
    fr_u_year number(1) default 1  constraint phoneInfo_univ_fr_u_year_nn not null,
    fr_ref number(7),
    
    constraint phoneInfo_univ_year_ck check (fr_u_year > 0  and  fr_u_year < 5),
    constraint phoneInfo_univ_idx_pk primary key(idx),
    constraint phoneInfo_univ_fr_ref_fk foreign key(fr_ref) references phoneInfo_basic(idx)
);    

create table phoneInfo_com(
    idx number(6),
    fr_c_company varchar2(20) default 'N' constraint phoneInfo_com_fr_c_company_nn not null,
    fr_ref number(6),   
    
    constraint phoneInfo_com_idx_pk primary key(idx),
    constraint phoneInfo_com_fr_ref_fk foreign key(fr_ref) references phoneInfo_basic(idx)
);


-------------------------------
-- contact 데이터 입력

-- 기본 정보 입력
insert into contact (pidx, name, phonenumber, address, email)
values (0001, '킹', 010-0000-0002, 'SEOUL', '0002@naver.com');

-- 학교 친구 정보 입력
insert into contact (pidx, name, phonenumber, address, email, category, major, grade)
values (0002, '정신우', 010-0000-0001, 'SEOUL', '0001@naver.com', 'UNIV', '컴퓨터공학', 3);

-- 회사 친구 정보 입력
insert into contact (pidx, name, phonenumber, address, email, category, company, dept, job)
values (0003, '일개미', 010-0000-0003, 'BUSAN', '0003@naver.com', 'COM', '라이엇게임', '밸런스부', '대리');

-- 모임 친구 정보 입력
insert into contact (pidx, name, phonenumber, address, email, category, CAFENAME, NICKNAME)
values (0004, '배짱이', 010-0000-0004, 'SEOUL', '0004@naver.com', 'CAFE', '게임동호회', '노세노세젊어노세');

desc contact;
select * from contact;
--------------------------------

desc PhoneInfo_basic;
desc phoneinfo_univ;
desc phoneinfo_com;
desc phoneinfo_cafe;
select * from PhoneInfo_basic;

-- 기본정보
insert into PhoneInfo_basic values
(0001, '김덕배', '010-0000-0001', 'kim@mancity.com', 'Manchester', default);
insert into PhoneInfo_basic values
(0002, '다실바', '010-0000-0002', 'david@mancity.com', 'manchester', default);
insert into PhoneInfo_basic values
(0003, '아게로', '010-0000-0002', 'ag@mancity.com', 'manchester', default);
insert into PhoneInfo_basic values
(0004, '펩', '010-0000-0003', 'pep@mancity.com','manchester', default);

-- 대학친구 입력
insert into PhoneInfo_univ values (0001, '미드필드학과', 4, 1);

-- 회사친구입력
insert into PhoneInfo_com values (0002, '맨체스터시티', 2);
insert into PhoneInfo_com values (0003, '맨체스터시티', 3);


select * from phoneinfo_basic b, phoneinfo_univ u, phoneinfo_com c where b.idx=u.fr_ref(+) and b.idx=c.fr_ref(+);
select * from phoneinfo_basic b, phoneinfo_univ u where b.idx=u.fr_ref;
select * from phoneinfo_basic b, phoneinfo_com c where b.idx=c.fr_ref; 


