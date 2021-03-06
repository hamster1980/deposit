INSERT INTO OPERATION_STATE (ID) VALUES ('STARTED');
INSERT INTO OPERATION_STATE (ID) VALUES ('CONFIRMED');
INSERT INTO OPERATION_STATE (ID) VALUES ('WORKING');
INSERT INTO OPERATION_STATE (ID) VALUES ('FINISHED');

INSERT INTO OPERATION_TYPE (ID) VALUES ('FLAT_RENTING');

INSERT INTO OPERATION_ROLE (ID) VALUES ('PAYER');
INSERT INTO OPERATION_ROLE (ID) VALUES ('MEDIATOR');
INSERT INTO OPERATION_ROLE (ID) VALUES ('CLAIMANT');

INSERT INTO OPERATION_PARTICIPANT_STATE (ID) VALUES ('WAITED');
INSERT INTO OPERATION_PARTICIPANT_STATE (ID) VALUES ('CONFIRMED');

INSERT INTO ERROR_CODE (ID, TYPE_ID, DEFAULT_MESSAGE) VALUES(1000, 'OPERATION_AMOUNT_IS_LESS_THEN_MIN', 'Amount is zero or less than it is possible');