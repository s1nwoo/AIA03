-- 2020.05.22


-- sub query

-- 평균 급여를 구하는 쿼리문을 서브 쿼리로 사용하여 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 문장은 다음과 같습니다
SELECT *
from emp
where sal > (SELECT avg(sal) from emp);


select deptno from emp where ename = 'SCOTT';

SELECT *
from emp
where deptno = (select deptno from emp where ename = 'SCOTT');



SELECT *
from emp
where deptno in (10,20);

select distinct deptno from emp where sal>=3000;

SELECT *
from emp
where deptno in (select distinct deptno from emp where sal>=2000);

select sal from emp where deptno=30;

select ename, sal
from emp
where sal> all (SELECT sal from emp where deptno=30);




-- rownum : 입력 순서의 번호
SELECT rownum, ename
from emp;



select name, sum(saleprice)
from orders o, customer c
where o.custid = c.custid
group by name;

SELECT custid, (SELECT name from customer c where o.custid=c.custid)as custom_name, sum(saleprice)
from orders o
group by custid;


select rownum, ename from emp;

-- 임금 탑3 구하기
select rownum, ename, empno, sal
from (select ename, empno, job, deptno, sal from emp order by sal desc)
where rownum<=3;

-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
select avg(saleprice) from orders;

select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice) from orders);

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.

select avg(saleprice) from orders where custid=1;

select orderid, custid, saleprice
from orders o
where saleprice > (select avg(saleprice) from orders a where a.custid=o.custid);

-- 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오.

select custid from customer where address like '%대한민국%';

select sum(saleprice)
from orders
where custid in(select custid from customer where address like '%대한민국%');

-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오.
SELECT saleprice FROM Orders WHERE custid='3';
select max(saleprice) from orders where custid = 3;


SELECT orderid, saleprice
FROM Orders
WHERE saleprice > ALL (SELECT saleprice FROM Orders WHERE custid='3');


-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.


SELECT SUM(saleprice) "total"
FROM Orders od
WHERE EXISTS (SELECT * FROM Customer cs WHERE address LIKE '%대한민국%' AND cs.custid=od.custid);

