CREATE TABLE PRODUCT (
	CODE INT AUTO_INCREMENT,
	NAME VARCHAR(100),
	PRICE INT,
	PICTUREURL VARCHAR(50),
	DESCRIPTION VARCHAR(1000),
	CONSTRAINT PK_PRODUCT PRIMARY KEY(CODE)
);