-- 2020.05.19

-- 특정 데이터를 추출하기 : where 절을 이용
-- select 컬럼명 from 테이블 이름 where 조건(true/false)

-- 전체 사원 중의 월 급여가 3000이상인 사원의 리스트
SELECT ename
FROM emp
where sal >= 3000;

-- 전체 사원중 10번 부서의 소속 사원의 이름과 직급을 출력
SELECT ename, job
FROM emp
WHERE deptno=10;


-- 컬럼의 값과 일치 여부 확인 : =

SELECT
    *
FROM emp
WHERE deptno=10;

-- 문자의 표현 : '작은 따움표로 묶는다 (대소문자 구분한다)
SELECT
    *
FROM emp
WHERE job='MANAGER';

SELECT
    *
FROM EMP
WHERE ENAME='SCOTT';


SELECT
    *
FROM EMP
WHERE HIREDATE = '80-12-17';

-- 논리 연산자(1) : and
SELECT
    *
FROM emp
WHERE deptno=10 and job = 'MANAGER';

-- 논리 연산자(2) : or
SELECT
    *
FROM emp
WHERE deptno=10 or job='MANAGER';

-- 논리 연산자(3) : not
SELECT
    *
FROM emp
WHERE NOT deptno=10 AND job='MANAGER';

-- BETWEEN AND 연산자
-- 1987년 입사자 리스트 출력
SELECT *
FROM EMP
WHERE HIREDATE BETWEEN '1987/01/01' AND '1987/12/31';

-- OR 연산을 간소화 시키는 IN 연산자
-- 컬럼 이름 IN(데이터1 , 데이터2, 데이터3,...)
-- 컬럼=데이터1 OR 컬럼=데이터2 OR 컬럼=데이터3 OR 컬럼=...

SELECT
    *
FROM EMP
WHERE COMM IN(300, 500, 1400);

-- I패턴 검색 : like 연산자
-- 컬럼 이름 like patten
-- patten : %, _
-- % : 0개 이상 문자열이 가능하다
-- _ : 1개의 자리수에 어떠한 문자가 와도 가능하다

SELECT
    *
FROM emp
WHERE ename like '%S%';

-- 두번 째가 A인 사원을 찾는다
SELECT *
FROM EMP
WHERE ENAME LIKE '_A%';


-- null 값 확인을 위한 연산자 : is null, is not null
-- 컬럼명 is null : 해당 컬럼의 값이 null 인 경우 true
-- 컬럼명 is not null : 해당 컬럼의 값이 null이 아닌 경우 true
-- COMM을 받지않은 사원 검색
SELECT *
FROM EMP
WHERE COMM IS NULL;

SELECT *
FROM EMP
WHERE COMM IS NOT NULL;

-- row의 정렬
-- 오름차순 : 작은쪽에서 큰쪽으로, asc(갱략가능, 기본값)
-- 내림차순 : 큰쪽에서 작은쪽으로, desc(명시적 사용)
SELECT ename, sal, hiredate, comm
FROM emp
--where empno>0;
--order by ename asc;
order by hiredate DESC;

-- 정렬의 여러가지 조건
-- 급여가 같은 경우 이름철자가 빠른 사람부터 출력
SELECT ename, sal
FROM EMP
ORDER BY SAL DESC, ENAME ASC;