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

ALTER TABLE BOARD ADD COLUMN GROUP_CODE INT;
ALTER TABLE BOARD ADD COLUMN GROUP_SEQ INT;
ALTER TABLE BOARD ADD COLUMN GROUP_LV INT;

UPDATE BOARD SET GROUP_CODE = NUM;
UPDATE BOARD SET GROUP_SEQ = 0;
UPDATE BOARD SET GROUP_LV = 0;

COMMIT;