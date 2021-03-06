-- begin DDCDI_IMPORT_CONFIGURATION
create table DDCDI_IMPORT_CONFIGURATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    TRANSACTION_STRATEGY varchar(50) not null,
    ENTITY_CLASS varchar(255) not null,
    AD_HOC boolean,
    TEMPLATE_ID uuid,
    COMMENT_ text,
    DATE_FORMAT varchar(255),
    BOOLEAN_TRUE_VALUE varchar(255),
    BOOLEAN_FALSE_VALUE varchar(255),
    PRE_COMMIT_SCRIPT text,
    FILE_CHARSET varchar(255),
    --
    primary key (ID)
)^
-- end DDCDI_IMPORT_CONFIGURATION
-- begin DDCDI_IMPORT_ATTRIBUTE_MAPPER
create table DDCDI_IMPORT_ATTRIBUTE_MAPPER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CONFIGURATION_ID uuid not null,
    MAPPER_MODE varchar(50) not null,
    ATTRIBUTE_TYPE varchar(50),
    ENTITY_ATTRIBUTE varchar(255),
    ASSOCIATION_LOOKUP_ATTRIBUTE varchar(255),
    FILE_COLUMN_NUMBER integer not null,
    FILE_COLUMN_ALIAS varchar(255),
    IS_REQUIRED_COLUMN boolean,
    CUSTOM_ATTRIBUTE_BIND_SCRIPT text,
    --
    primary key (ID)
)^
-- end DDCDI_IMPORT_ATTRIBUTE_MAPPER
-- begin DDCDI_UNIQUE_CONFIGURATION_ATTRIBUTE
create table DDCDI_UNIQUE_CONFIGURATION_ATTRIBUTE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ENTITY_ATTRIBUTE varchar(255) not null,
    UNIQUE_CONFIGURATION_ID uuid not null,
    --
    primary key (ID)
)^
-- end DDCDI_UNIQUE_CONFIGURATION_ATTRIBUTE
-- begin DDCDI_UNIQUE_CONFIGURATION
create table DDCDI_UNIQUE_CONFIGURATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    POLICY varchar(50) not null,
    IMPORT_CONFIGURATION_ID uuid not null,
    --
    primary key (ID)
)^
-- end DDCDI_UNIQUE_CONFIGURATION
-- begin DDCDI_IMPORT_EXEC_DETAIL
create table DDCDI_IMPORT_EXEC_DETAIL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MESSAGE varchar(4000) not null,
    LEVEL_ varchar(50) not null,
    TIME_ timestamp not null,
    STACKTRACE text,
    IMPORT_EXEC_ID uuid not null,
    DATA_ROW text,
    DATA_ROW_INDEX integer,
    ENTITY_INSTANCE text,
    CATEGORY varchar(50),
    --
    primary key (ID)
)^
-- end DDCDI_IMPORT_EXEC_DETAIL
-- begin DDCDI_IMPORT_EXEC
create table DDCDI_IMPORT_EXEC (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FILE_ID uuid,
    STARTED_AT timestamp,
    FINISHED_AT timestamp,
    ENTITIES_PROCESSED integer,
    ENTITIES_IMPORT_SUCCESS integer,
    ENTITIES_IMPORT_VAL_ERROR integer,
    ENTITIES_PRE_COMMIT_SKIPPED integer,
    ENTITIES_UNIQUE_CONSTRAINT_SKIPPED integer,
    SUCCESS boolean not null,
    CONFIGURATION_ID uuid,
    --
    primary key (ID)
)^
-- end DDCDI_IMPORT_EXEC
-- begin DDCDI_OPERATION
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
    OPERATION_TYPE_ID uuid,
    PURPOSE_OF_PAYMENT varchar(255),
    INCOME varchar(255),
    BANK varchar(255),
    INCOMEG double precision,
    NR varchar(255),
    NRG integer,
    TYPE_ varchar(255),
    OUTCOME varchar(255),
    COUNTER_AGENT_ACCOUNT_NUMBER varchar(255),
    COUNTER_AGENT_BANK_NAME varchar(255),
    COUNTER_AGENT_BANK_CORR_ACCOUNT varchar(255),
    OUTCOMEG double precision,
    COUNTER_AGENT_BANK_BIK varchar(255),
    OPERATION_DATE date,
    COUNTER_AGENT_INN varchar(255),
    COUNTER_AGENT varchar(255),
    ACCOUNT_NUMBER varchar(255),
    DATE_ timestamp,
    DOC_DATE_TEXT varchar(255),
    OPERATION_DATE_TEXT varchar(255),
    DOC_NUMBER varchar(255),
    OSTATOK double precision,
    OSTATOK_TEXT varchar(255),
    OSTATOK_DATE_TEXT varchar(255),
    --
    primary key (ID)
)^
-- end DDCDI_OPERATION
-- begin DDCDI_COUNTER_AGENT
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
)^
-- end DDCDI_COUNTER_AGENT
-- begin DDCDI_ACCOUNT
create table DDCDI_ACCOUNT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COMPANY varchar(255),
    NAME varchar(255),
    ACCOUNT_NUMBER varchar(255),
    BANK varchar(255),
    --
    primary key (ID)
)^
-- end DDCDI_ACCOUNT
-- begin ГОДОВОЙ_ОТЧЕТ
create table годовой_отчет (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    СЧЕТ varchar(255),
    ГОД varchar(255),
    КОМПАНИЯ varchar(255),
    Наименование varchar(255),
    ЗАЧИСЛЕНИЯ varchar(255),
    СПИСАНИЯ varchar(255),
    БАЛАНС varchar(255),
    конечный_остаток varchar(255),
    начальный_остаток varchar(255),
    БАНК varchar(255),
    --
    primary key (ID)
)^
-- end ГОДОВОЙ_ОТЧЕТ
-- begin DDCDI_OPERATION_TYPE
create table DDCDI_OPERATION_TYPE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end DDCDI_OPERATION_TYPE
