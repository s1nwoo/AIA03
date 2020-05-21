-- 2020.05.21


--JOIN

select * from emp;
select * from dept;

select *
from emp, dept;

-- cross JOIN
select ename, dname
from emp e, dept d
where e.deptno = d.deptno;

select *
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid;

select * from emp;
select * from salgrade; 

select ename, sal, grade
from emp e, salgrade s
--where e.sal >= s.losal and e.sal <= s.hisal;
where sal between losal and hisal;


-- Self JOIN.
-- 관리자의 이름을 알아보자
SELECT * from emp;

select e.ename || '의 상사는' || m.ename || '입니다.'
from emp e, emp m
where e.mgr = m.empno;

-- Outer JOIN
-- NULL 포함하기 "(+)"
select e.ename || '의 상사는' || m.ename || '입니다.'
from emp e, emp m
where e.mgr = m.empno(+);

select e.ename, e.empno, e.sal, e.comm, nvl(m.ename, '관리자 없음')
from emp e, emp m
where e.mgr = m.empno(+);


SELECT *
from emp e left outer join emp m
on e.mgr = m.empno;


SELECT * FROM EMP CROSS JOIN DEPT;

SELECT ename, dname
from emp inner join dept
on emp.deptno = dept.deptno;

SELECT ename, dname
from emp inner join dept
using(deptno);


SELECT ename, dname
from emp natural join dept;

