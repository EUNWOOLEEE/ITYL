-- 문제1
show databases;

use employees;

-- show tables;
show tables from employees;

desc employees;


-- 문제2
desc titles;

select first_name from employees;

select first_name, last_name, gender from employees;


-- 문제3
select first_name, gender, hire_date from employees;


-- 문제5
select * from usertbl where name = '김경호';

select * from usertbl where birthYear >= 1970 && height >= 182;


-- 문제6
select * from usertbl where 180 <= height && height <= 183;

select * from usertbl where addr = '경남' || addr = '전남' || addr = '경북';

select * from usertbl where name like '김%';


-- 문제7
select name, height from usertbl where height > (select height from usertbl where name = '김경호');


-- 문제8
select * from usertbl order by mdate;
-- select * from usertbl order by mdate asc;

select * from usertbl order by mdate desc;

select * from usertbl order by height desc, name desc;


-- 문제9
select distinct addr from usertbl;


-- 문제10
select population from city where countrycode = 'KOR' order by population desc;

select countrycode, population from city order by countrycode, population desc;

select count(*) from city where countrycode = 'KOR';

select district from city where countrycode = 'KOR' || countrycode = 'CHN' || countrycode = 'JPN';

select district from city where countrycode = 'KOR' && population >= 1000000;

select district from city where countrycode = 'KOR' order by population desc limit 10;

select * from city where countrycode = 'KOR' && 1000000 <= population && population <= 5000000;