CREATE TABLE STUDENT (
	SID INT AUTO_INCREMENT,
	NAME VARCHAR(10),
	AGE INT,
	SCORE INT,
	CONSTRAINT PK_STUDENT PRIMARY KEY(SID)
);

INSERT INTO STUDENT VALUES('1', '홍길동', '25', '98');
INSERT INTO STUDENT VALUES('2', '강감찬', '23', '87');
INSERT INTO STUDENT VALUES('3', '이순신', '25', '73');
INSERT INTO STUDENT VALUES('4', '김유신', '25', '95');
INSERT INTO STUDENT VALUES('5', '유관순', '25', '80');

COMMIT;
