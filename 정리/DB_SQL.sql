/* 주석  스프링부트 연동 */
-- 한 줄 주석

-- 데이터베이스 생성

create database hrdb_spring;

-- 데이터베이스 확인
use hrdb_spring;

select database();

-- 모든 테이블 확인

show tables;

-- Employee 테이블 생성
/*
create table  [테이블 명] (
컬럼명 	데이터타입 	제약사항 
)
*/

create table employee(
sno 	int 	primary key, -- 사원번호
name 	varchar(10),
address varchar(30)
);

-- 테이블 생성 확인
desc employee;

-- C (create) : 데이터 추가 
-- R (read)   : 데이터 조회 
-- U (update) : 데이터 수정 
-- D (delete) : 데이터 삭제

insert into employee(sno, name, address)
value(1234, "홍길동", "서울시 강남구");

insert into employee(sno, name, address)
value(4321, "홍길동", "서울시 강남구");
insert into employee(sno, name, address)
value(4320, "이순신", "아산시 신창면");


-- 데이터 조회 
select * from employee;
select * from employee where sno = 1234;
select sno, name, address from employee where sno = 1234;


-- 데이터 수정 
update employee set name = '김길자' where sno =1234;

