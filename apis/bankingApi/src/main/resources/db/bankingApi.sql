CREATE USER banker with PASSWORD 'jw8s0F4';

CREATE TABLESPACE bank_default LOCATION '/Library/PostgreSQL/12/data';
grant create on tablespace bank_default to banker;
CREATE DATABASE bank
    WITH
    OWNER = banker
    ENCODING = 'UTF8'
    LC_COLLATE = 'uk_UA.UTF-8'
    LC_CTYPE = 'uk_UA.UTF-8'
    TABLESPACE = bank_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE bank
    IS 'Test for creating the bank DB';

CREATE SCHEMA IF NOT EXISTS banking AUTHORIZATION banker ;

CREATE TABLE banking.AccountStatement
(
    ID INTEGER,
    uid varchar(10),
    Public boolean,
    TransactionDate date,
    Type varchar (4),
    SortCode varchar(8),
    AccountNumber int,
    Description varchar(100),
    Credit int,
    Debit int,
    Ballance int,
    ACL int,
    CONSTRAINT ID PRIMARY KEY(ID)
);
