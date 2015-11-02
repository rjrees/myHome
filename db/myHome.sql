
CREATE TABLE RecipeIngredients
(
ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
UID varchar(10),
Description varchar(255),
Receipe int,
Created date,
updated date
);

CREATE TABLE RecipeSteps
(
ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
UID varchar(10),
StepPosition int,
Step varchar(500),
Recipe int,
Created date,
updated date
);

CREATE TABLE Recipe
(
ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
UID varchar(10),
Name varchar(500),
Description varchar(500),
Created date,
updated date
);

CREATE TABLE BankStatement
(
ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
UID varchar(10),
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
);

CREATE TABLE messages
(
ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
UID varchar(10),
Created date,
Validfrom date,
ValidExpiration date,
Description varchar(100),
Message varchar(500),
);
