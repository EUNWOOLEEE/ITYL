USE sqldb;

SELECT * FROM userTbl;
SELECT * FROM buyTbl;

-- 문제1
SELECT *
FROM userTbl
JOIN buyTbl
	ON userTbl.userID = buyTbl.userID;
    
SELECT *
FROM userTbl
JOIN buyTbl
	ON userTbl.userID = buyTbl.userID
WHERE userTbl.userID = 'JYP';

-- 문제2

SELECT u.userID, u.name, b.prodName, u.addr, CONCAT(u.mobile1, u.mobile2)
FROM userTbl u
LEFT JOIN buyTbl b
	ON u.userID = b.userID
ORDER BY u.userID;

-- 문제3

SELECT *
FROM userTbl
WHERE name NOT IN(SELECT name FROM userTbl WHERE mobile1 IS NULL);

SELECT *
FROM userTbl
WHERE name IN(SELECT name FROM userTbl WHERE mobile1 IS NULL);
