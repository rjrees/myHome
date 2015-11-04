USE myHome;
CREATE TABLE IF NOT EXISTS  Recipe
(
id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
uid varchar(10),
name varchar(500),
description varchar(500),
created_on datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
updated datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Recipe';

CREATE TABLE IF NOT EXISTS RecipeIngredients
(
id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
UID varchar(10),
Description varchar(255),
Receipe int,
created_on datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
updated datetime(6),
FOREIGN KEY (id) REFERENCES Recipe(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Recipe';

CREATE TABLE IF NOT EXISTS  RecipeSteps
(
ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
UID varchar(10),
StepPosition int,
Step varchar(500),
Recipe int,
created_on datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
updated date,
PRIMARY KEY (`id`),
FOREIGN KEY (id) REFERENCES Recipe(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Recipe';

CREATE TABLE IF NOT EXISTS  BankStatement
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
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Recipe';

CREATE TABLE IF NOT EXISTS  messages
(
ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
UID varchar(10),
Created date, `created_on` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
ValidFrom date,
ValidExpiration date,
Description varchar(100),
Message varchar(500),
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Recipe';