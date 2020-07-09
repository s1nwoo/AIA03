-- 방명록 테이블

create table guestbook_message(
    message_id number(4) PRIMARY key,
    guest_name varchar2(50) not null,
    password varchar(10) not null,
    message varchar2(2000) not null
    

)