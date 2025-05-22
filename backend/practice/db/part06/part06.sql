-- 문제1
USE sqldb;

CREATE TABLE IF NOT EXISTS tbl1(
	a INT PRIMARY KEY,
    b INT,
    c INT
);

SHOW INDEX FROM tbl1;

-- 문제2
CREATE TABLE IF NOT EXISTS tbl2(
	a INT PRIMARY KEY,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);

SHOW INDEX FROM tbl2;

-- 문제3
CREATE TABLE IF NOT EXISTS tbl3(
	a INT UNIQUE,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);

SHOW INDEX FROM tbl3;

-- 문제4
CREATE TABLE IF NOT EXISTS tbl4(
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);

SHOW INDEX FROM tbl4;

-- 문제5
CREATE TABLE IF NOT EXISTS tbl5(
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT PRIMARY KEY
);

SHOW INDEX FROM tbl5;

-- 문제6
USE testdb;

CREATE TABLE IF NOT EXISTS usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL,
    addr NCHAR(2) NOT NULL
);

INSERT INTO usertbl VALUE ('LSG', '이승기', 1987, '서울');
INSERT INTO usertbl VALUE ('KBS', '김범수', 1979, '경남');
INSERT INTO usertbl VALUE ('KKH', '김경호', 1971, '전남');
INSERT INTO usertbl VALUE ('JYP', '조용필', 1950, '경기');
INSERT INTO usertbl VALUE ('S나', '성시경', 1979, '서울');

SELECT * FROM usertbl;

-- 문제7
ALTER TABLE usertbl DROP PRIMARY KEY;

ALTER TABLE usertbl
ADD CONSTRAINT pk_name PRIMARY KEY(name);

SELECT * FROM usertbl;