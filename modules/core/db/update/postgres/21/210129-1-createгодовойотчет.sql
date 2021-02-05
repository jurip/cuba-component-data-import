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
);