
CREATE TABLE OPERATION_STATE(
	ID VARCHAR(20) NOT NULL
	, DESCRIPTION VARCHAR(512)
	, PRIMARY KEY (ID)
);

CREATE TABLE OPERATION_TYPE(
	ID VARCHAR(20) NOT NULL
	, DESCRIPTION VARCHAR(512)
	, PRIMARY KEY (ID)
);

CREATE TABLE OPERATION(
	ID INT NOT NULL AUTO_INCREMENT
	, CREATION_DATE TIMESTAMP  
	, STATE_ID VARCHAR(20) NOT NULL
	, TYPE_ID VARCHAR(20) NOT NULL
	, AMOUNT_VALUE NUMBER NOT NULL
	, AMOUNT_CURRENCY VARCHAR(5) NOT NULL
	, PRIMARY KEY (ID)
	, CONSTRAINT FK_OPERATION_1 FOREIGN KEY (STATE_ID) REFERENCES OPERATION_STATE(ID)
	, CONSTRAINT FK_OPERATION_2 FOREIGN KEY (TYPE_ID) REFERENCES OPERATION_TYPE(ID)
);

CREATE TABLE OPERATION_ROLE(
	ID VARCHAR(20) NOT NULL
	, DESCRIPTION VARCHAR(512)
	, PRIMARY KEY (ID)
);

CREATE TABLE OPERATION_PARTICIPANT_STATE(
	ID VARCHAR(20) NOT NULL
	, DESCRIPTION VARCHAR(512)
	, PRIMARY KEY (ID)
);

CREATE TABLE OPERATION_PARTICIPANT(
	ID INT NOT NULL AUTO_INCREMENT
	, OPERATION_ID INT NOT NULL
	, PERSON_ID INT NOT NULL
	, ROLE_ID VARCHAR(20) NOT NULL
	, STATE_ID VARCHAR(20) NOT NULL
	, PRIMARY KEY (ID)
	, CONSTRAINT FK_OPERATION_PARTICIPANT_1 FOREIGN KEY (OPERATION_ID) REFERENCES OPERATION(ID)
	, CONSTRAINT FK_OPERATION_PARTICIPANT_2 FOREIGN KEY (PERSON_ID) REFERENCES PERSON(ID)
	, CONSTRAINT FK_OPERATION_PARTICIPANT_3 FOREIGN KEY (ROLE_ID) REFERENCES OPERATION_ROLE(ID)
	, CONSTRAINT FK_OPERATION_PARTICIPANT_4 FOREIGN KEY (STATE_ID) REFERENCES OPERATION_PARTICIPANT_STATE(ID)
);
