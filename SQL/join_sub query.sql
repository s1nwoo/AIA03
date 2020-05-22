--1 마당서점의 고객이 요구하는 다음질문에 대해 SQL문을 작성하시오.

SELECT * FROM book;
SELECT * FROM Customer;
SELECT * FROM Orders;

--(5) 박지성이 구매한 도서의 출판사수
-- select bookid from orders where custid=1;

SELECT count(publisher)
from book
where bookid in (select bookid from orders where custid=1);


--(6) 박지성이 구매한 도서의이름, 가격, 정가와 판매가격의 차이
-- select bookid, saleprice from orders where custid = 1;
-- select bookid, price from book where bookid BETWEEN 1 and 3;

select bookname, price, price - (select saleprice from orders o where o.bookid=b.bookid) as "가격 차이"
from book b
where bookid in (select bookid from orders where custid = 1);


--(7) 박지성이 구매하지 않은 도서의 이름
-- select bookid from orders where not custid = 1;

select bookname
from book
where bookid not in(select bookid from orders where custid = 1);


--2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL문을 작성하시오.

SELECT * FROM book;
SELECT * FROM Customer;
SELECT * FROM Orders;

--(8) 주문하지않은 고객의이름(부속질의사용)
-- select DISTINCT(custid) from orders;

select name
from customer
where custid not in(select DISTINCT(custid) from orders);


--(9) 주문금액의 총액과 주문의 평균금액

select sum(saleprice) as "주문 총액", avg(saleprice) as "주문 평균금액"
from orders;


--(10) 고객의 이름과 고객별 구매액

--select custid, name from customer;
--select custid, sum(saleprice) from orders group by custid;

select c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid group by c.name;


--(11) 고객의 이름과 고객이 구매한 도서목록

-- select custid, name from customer;
-- select bookid, bookname from book;
-- select custid, bookid from orders;

select name, bookname
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid order by name;


--(12) 도서의가격(Book테이블)과 판매가격(Orders테이블)의 차이가 가장 많은 주문

select o.orderid as "주문번호", b.price - o.saleprice as "가격 차이"
from book b ,orders o
where b.bookid = o.bookid;

select *
from (select o.orderid as "주문번호", b.price - o.saleprice as "가격 차이"
from book b ,orders o
where b.bookid = o.bookid) cs
having max(cs."가격 차이"); > cs.


--(13) 도서의 판매액평균보다 자신의 구매액평균이 더 높은 고객의 이름


--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름