
CREATE TABLE Recipe_Ingredients
(
ID int,
UID varchar(10),
Description varchar(255),
Receipe int,
Created date,
updated date
);

CREATE TABLE Recipe_steps
(
ID int,
UID varchar(10),
StepPosition int,
Step varchar(500),
Recipe int,
Created date,
updated date
);

CREATE TABLE Recipe
(
ID int,
UID varchar(10),
Name varchar(500),
Description varchar(500),
Created date,
updated date
);



