create table DDCDI_COUNTER_AGENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ACCOUNT_NUMBER varchar(255),
    NAME varchar(255),
    --
    primary key (ID)
);