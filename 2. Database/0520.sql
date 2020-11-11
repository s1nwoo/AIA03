

-- 숫자 함수

SELECT mod(10,3)
FROM dual;


-- 변환함수 
-- TO_CHAR(날짜데이터, '출력방식')
-- data -> varchar2

SELECT sysdate, to_char(sysdate, 'YYYY.MM.DD')
FROM DUAL;

SELECT ename, hiredate, to_char(hiredate, 'YYYY.MM.DD') as hiredate
FROM EMP;   

SELECT sysdate, to_char(sysdate, 'HH24.MI.SS')
from dual;

-- 2020.05.20. 11:26
SELECT to_char(sysdate, 'YYYY.MM.DD. HH24:MI')
from dual;

-- number -> varchar2
SELECT to_char(12500, '000,000.000')
from dual;

SELECT to_char(12500, 'L999,999')
from dual;

SELECT to_char(3.14, '999,999.999')
from dual;

SELECT ename, sal, to_char(sal*1000, 'L999,999,999'), to_char(sal*1000*12+nvl(comm,0), 'L999,999,999') as Income
FROM EMP
order by income desc;


-- TO_DATE
-- TO_DATE(원본, 패턴)
-- str -> date 

select to_date('19810220', 'YYYYMMDD')
from dual;
select to_date('1981/02/20', 'YYYY/MM/DD')
from dual;

select ename, hiredate
from emp
where hiredate = to_date('1981/02/20', 'YYYY/MM/DD');

SELECT SYSDATE, TO_DATE('2020/12/25', 'YYYY/MM/DD'), trunc(TO_DATE('20201225', 'YYYYMMDD') - SYSDATE)
FROM DUAL;

SELECT sysdate, trunc(sysdate-to_date('19920928','yyyymmdd'))
from dual;


-- TO_NUMBER
-- TO_NUMBER(원본, '패턴')
-- str -> number : 산술연산을 목적으로 변환

select to_number('20,000', '999,999') - to_number('10,000','999,999')
from dual;


-- DECODE 함수 : if 나 switch 구문과 유사하다
-- DECODE(표현식, 조건1, 결과1,
--               조건2, 결과2,
--               기본결과 n)

select ename, deptno, DECODE(deptno, 10, 'ACCOUNTING',
                                     20, 'RESEARCH',
                                     30, 'SALES',
                                     40, 'OPERATIONS')
from emp
order by deptno asc;

select ename, job, sal, DECODE(job, 'ANALYST', sal*1.05,
                                    'SALESMAN', sal*1.1,
                                    'MANAGER', sal*1.15,
                                    'CLERK', sal*1.2, sal) as upsal
from emp;


select ename, deptno, CASE WHEN deptno=10 then 'ACCOUNTING'
                            WHEN deptno=20 then 'RESEARCH'
                            WHEN deptno=30 then 'SALES'
                            when deptno=40 then 'OPERATIONS'
                            else 'no name'
                            end as dname
from emp
order by dname asc;


-- 그룹함수(집합함수)  -------------------------★★★★★
-- sum, avg, count, max, min

-- sum(컬럼) : 해당 컬럼의 데이터들의 합 반환
select sum(sal) as totalsal
from emp;

select to_char(sum(sal)*1000,'L999,999,999') as totalsal
from emp;

-- avg(컬럼) : 해당 컬럼의 데이터들의 평균값을 반환
select trunc(avg(sal))
from emp;

-- max, min(컬럼) : 해당 컬럼의 데이터들의 최대값과 최소값을 반환
select max(sal), min(sal), max(comm), min(comm)
from emp;

-- count(컬럼 or *) : 행(row)의 개수를 반환
-- * : 입력된 모두를 구할 때
-- null은 개수를 세지 않는다.
-- distinct : 중복제거
select count(*), count(comm)
from emp;

select distinct job 
from emp 
order by job;

select count(job), count(distinct job)
from emp 
order by job;

-- group by 절 : 특정컬럼으로 그룹핑을 해준다 ------------★★★★★
select deptno
from emp
group by deptno;

-- 소속 부서별 평균 임금
select deptno, round(avg(sal),0)
from emp
group by deptno
order by deptno;

-- 소속 부서별 최대 급여와 최소 급여
select deptno, max(sal), min(sal)
from emp
group by deptno
order by deptno;

-- 소속 부서별 사원 수와 커미션을 받는 사원 수
select deptno, count(*), count(comm)
from emp
where comm != 0
group by deptno
order by deptno;

-- having 절  --------------------★★★★★
-- having : 그룹의 결과를 제한할 때 사용
select deptno, round(avg(sal),0) , count(*), count(comm), avg(comm)
from emp
group by deptno
having avg(sal)<=2000;

-- 직급별 지표 출력
select job, count(*) as "직급별 사원 수",
            sum(sal) as "직급별 총 급여",
            round(avg(sal),0) as "직급별 평균 급여",
            nvl(sum(comm),0) as "직급별 총 중개료",
            max(sal) as "직급별 최고 급여"
from emp
group by job
-- 직급의 인원이 2명 이상인 직급
-- having count(*) > 1
-- 직급의 인원이 2명 이상이면서 총 급여가 5000이상인 직급
having count(*) > 1 and sum(sal) >= 5000;

select deptno, job
from emp
group by deptno, job
order by deptno
;
