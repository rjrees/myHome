CREATE SCHEMA bankingApi;
CREATE SCHEMA AUTHORIZATION bankingApi;

create if not exist USER bankingapi WITH ENCRYPTED PASSWORD '$password';

CREATE SCHEMA IF NOT EXISTS banking AUTHORIZATION bankingapi;

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
    CONSTRAINT ID PRIMARY KEY(ID,uid)
);