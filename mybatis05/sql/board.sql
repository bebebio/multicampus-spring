CREATE TABLE BOARD (
	NUM INT AUTO_INCREMENT,
	PASS VARCHAR(30),
	NAME VARCHAR(30),
	EMAIL VARCHAR(30),
	TITLE VARCHAR(50),
	CONTENT VARCHAR(1000),
	READCOUNT INT,
	WRITEDATE DATE,
	CONSTRAINT PK_BOARD PRIMARY KEY(NUM)
);