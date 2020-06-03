
create sequence contact_pidx_seq
INCREMENT BY 1 START WITH 1;
DROP SEQUENCE contact_pidx_seq;

select * from contact;  
desc contact;

select count(*) from contact where name = '테스터1';

select * from contact where name = '테스터1'  ;