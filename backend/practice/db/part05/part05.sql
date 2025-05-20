-- 문제1
DROP DATABASE IF EXISTS tabledb;
CREATE DATABASE tabledb;

USE tabledb;

CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    addr CHAR(2) NOT NULL,
    mobile1 CHAR(3),
    mobile2 CHAR(8),
    height SMALLINT,
    mDate DATE
);

-- 문제2
CREATE TABLE buytbl(
	num INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userID CHAR(8) NOT NULL,
    prodName CHAR(6) NOT NULL,
    groupName CHAR(4),
    price INT NOT NULL,
    amount SMALLINT NOT NULL,
    FOREIGN KEY(userID) REFERENCES usertbl(userID)
);

-- 문제3
INSERT INTO usertbl VALUES ('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES ('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES ('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

SELECT * FROM usertbl;

-- 외래 키인 userID가 연결될 기본 키 중 JYP가 없음
INSERT INTO buytbl VALUES ('KBS', '운동화', NULL, 30, 2);
INSERT INTO buytbl VALUES ('KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES ('JYP', '모니터', '전자', 200, 1);

-- 문제4
DROP TABLE IF EXISTS buytbl;
DROP TABLE IF EXISTS usertbl;

CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL
);

-- 문제5
DROP TABLE IF EXISTS prodtbl;
CREATE TABLE prodtbl(
	prodCode CHAR(3) NOT NULL,
    prodID CHAR(4) NOT NULL,
    prodDate DATETIME NOT NULL,
    proCur CHAR(10),
    CONSTRAINT PK_prodtbl_prodCodeID PRIMARY KEY (prodCode, prodID)
);

-- 문제6
USE sqldb;

DROP VIEW IF EXISTS tmpview;

SELECT * FROM usertbl;

CREATE VIEW tmpview
AS
SELECT u.userID, u.name, b.prodName, u.addr, CONCAT(mobile1, mobile2) AS '연락처'
FROM usertbl u
	JOIN buytbl b
    ON u.userID = b.userID;

SELECT * FROM tmpview;

SELECT * FROM tmpview WHERE name = '김범수';