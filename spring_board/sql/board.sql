ALTER TABLE BOARD DROP GROUP_CODE;
ALTER TABLE BOARD DROP GROUP_SEQ;
ALTER TABLE BOARD DROP GROUP_LV;

ALTER TABLE BOARD ADD FILEURI VARCHAR(50);
ALTER TABLE BOARD ADD FILEID INT;