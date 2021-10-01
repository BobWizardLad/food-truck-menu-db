# Robert Bell 010857731 2021-04-21
# Definition of the Food Truck! Database

CREATE TABLE Menu(
    id int,
    name char(50) NOT NULL,
    addon int NOT NULL,
    price DECIMAL(5,2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Addons(
    id int,
    name char(50) NOT NULL,
    price DECIMAL(5,2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Employees(
    id int,
    name char(50) NOT NULL,
    occupation char(50) NOT NULL,
    phonenumber char(25) NOT NULL,
    address char(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Sales(
    transid int,
    itemid int NOT NULL,
    addon1id int,
    addon2id int,
    saledate date NOT NULL,
    PRIMARY KEY (transid),
    FOREIGN KEY (itemid) REFERENCES Menu(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (addon1id) REFERENCES Addons(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (addon2id) REFERENCES Addons(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE Menu;
DROP TABLE Addons;
DROP TABLE Employees;
DROP TABLE Sales;