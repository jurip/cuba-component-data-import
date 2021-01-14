create table DDCDI_OPERATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PURPOSE_OF_PAYMENT varchar(255),
    INCOME varchar(255),
    INCOMEG double precision,
    OUTCOME varchar(255),
    COUNTER_AGENT_ACCOUNT_NUMBER varchar(255),
    COUNTER_AGENT_BANK_NAME varchar(255),
    COUNTER_AGENT_BANK_CORR_ACCOUNT varchar(255),
    COUNTER_AGENT_BANK_BIK varchar(255),
    OPERATION_DATE date,
    COUNTER_AGENT_INN varchar(255),
    COUNTER_AGENT varchar(255),
    ACCOUNT_NUMBER varchar(255),
    DATE_ timestamp,
    DOC_DATE_TEXT varchar(255),
    OPERATION_DATE_TEXT varchar(255),
    DOC_NUMBER varchar(255),
    --
    primary key (ID)
);