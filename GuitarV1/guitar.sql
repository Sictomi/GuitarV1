--
-- File generated with SQLiteStudio v3.0.7 on 周三 5月 25 21:01:12 2016
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Size
CREATE TABLE Size (sizeID VARCHAR (64) PRIMARY KEY UNIQUE, sizeName VARCHAR (64));
INSERT INTO Size (sizeID, sizeName) VALUES ('001', 'FENDER');
INSERT INTO Size (sizeID, sizeName) VALUES ('002', 'MARTIN');
INSERT INTO Size (sizeID, sizeName) VALUES ('003', 'GIBSON');
INSERT INTO Size (sizeID, sizeName) VALUES ('004', 'COLLINGS');
INSERT INTO Size (sizeID, sizeName) VALUES ('005', 'OLSON');
INSERT INTO Size (sizeID, sizeName) VALUES ('006', 'RYAN');
INSERT INTO Size (sizeID, sizeName) VALUES ('007', 'ANY');
INSERT INTO Size (sizeID, sizeName) VALUES ('008', 'PRS');

-- Table: Type
CREATE TABLE [Type](
    [typeID] VARCHAR(64) PRIMARY KEY UNIQUE, 
    [typeName] VARCHAR(64));
INSERT INTO Type (typeID, typeName) VALUES ('001', 'ACOUSTIC');
INSERT INTO Type (typeID, typeName) VALUES ('002', 'ELECTRIC');

-- Table: Guitar
CREATE TABLE [Guitar](
    [serialNumber] VARCHAR(64) PRIMARY KEY NOT NULL UNIQUE, 
    [backWood] VARCHAR(64) NOT NULL, 
    [topWood] VARCHAR(64) NOT NULL, 
    [price] DOUBLE(32) NOT NULL, 
    [builder] VARCHAR(64), 
    [model] VARCHAR(64), 
    [type] VARCHAR(32), 
    [numStrings] VARCHAR(64), 
    CONSTRAINT [backwoodname] FOREIGN KEY([backWood]) REFERENCES Wood([woodName]), 
    CONSTRAINT [topwoodname] FOREIGN KEY([topWood]) REFERENCES Wood([woodName]));
INSERT INTO Guitar (serialNumber, backWood, topWood, price, builder, model, type, numStrings) VALUES ('100001', 'CEDAR', 'MAPLE', 64, 'AMY', '01', 'ACOUSTIC', '6');
INSERT INTO Guitar (serialNumber, backWood, topWood, price, builder, model, type, numStrings) VALUES ('100002', 'ALDER', 'ALDER', 23, 'RYAN', '02', 'ELECTRIC', '6');

-- Table: Wood
CREATE TABLE [Wood](
    [woodID] VARCHAR(32) PRIMARY KEY UNIQUE, 
    [woodName] VARCHAR(128));
INSERT INTO Wood (woodID, woodName) VALUES ('001', 'INDIAN_ROSEWOOD');
INSERT INTO Wood (woodID, woodName) VALUES ('002', 'COCOBOLO');
INSERT INTO Wood (woodID, woodName) VALUES ('003', 'BRAZILIAN_ROSEWOOD');
INSERT INTO Wood (woodID, woodName) VALUES ('004', 'MAHOGANY');
INSERT INTO Wood (woodID, woodName) VALUES ('005', 'MAPLE');
INSERT INTO Wood (woodID, woodName) VALUES ('006', 'CEDAR');
INSERT INTO Wood (woodID, woodName) VALUES ('007', 'ADIRONDACK');
INSERT INTO Wood (woodID, woodName) VALUES ('008', 'ALDER');
INSERT INTO Wood (woodID, woodName) VALUES ('009', 'SITKA');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
