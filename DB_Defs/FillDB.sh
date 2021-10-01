# Robert Bell 010857731 2021-04-21
# Default values fed into the database for Food Truck!

INSERT INTO Menu VALUES (1, "Fish Tacos", 2, 7.99);
INSERT INTO Menu VALUES (2, "Beef Tacos", 2, 6.99);
INSERT INTO Menu VALUES (3, "Chicken Tacos", 2, 5.99);
INSERT INTO Menu VALUES (4, "Stuffed Poblano Tacos", 2, 6.99);
INSERT INTO Menu VALUES (5, "Chilaquiles Torta", 1, 7.99);
INSERT INTO Menu VALUES (6, "Pambazo", 1, 7.99);
INSERT INTO Menu VALUES (7, "Veggie Quesadilla", 2, 6.99);
INSERT INTO Menu VALUES (8, "Beef Quesadilla", 2, 6.99);
INSERT INTO Menu VALUES (9, "Mixed Fajitas", 1, 10.99);

INSERT INTO Addons VALUES (1, "Salsa Roja", 1.99);
INSERT INTO Addons VALUES (2, "Queso", 3.99);
INSERT INTO Addons VALUES (3, "Pico de Gaillo", 1.99);
INSERT INTO Addons VALUES (4, "Nopales", 2.99);
INSERT INTO Addons VALUES (5, "Salsa Verde", 1.99);
INSERT INTO Addons VALUES (6, "Chorizo Queso", 4.99);

INSERT INTO Employees VALUES (1, "Bob", "Cook", 2343456789, "FAYETTEVILLE");
INSERT INTO Employees VALUES (2, "Alice", "Cook", 9876542756, "FAYETTEVILLE");
INSERT INTO Employees VALUES (3, "John", "Driver", 6784563746, "ROGERS");
INSERT INTO Employees VALUES (4, "Shauna", "Cook", 9875678374, "BELLA VISTA");
INSERT INTO Employees VALUES (5, "Harold", "Prep", 8769583746, "ROGERS");

INSERT INTO Sales VALUES (1000, 5, 5, NULL, DATE("2021-03-27"));
INSERT INTO Sales VALUES (1001, 2, 1, 2, DATE("2021-04-01"));
INSERT INTO Sales VALUES (1002, 9, 6, NULL, DATE("2021-04-05"));
INSERT INTO Sales VALUES (1003, 7, 4, 3, DATE("2021-04-05"));
INSERT INTO Sales VALUES (1004, 6, 3, NULL, DATE("2021-04-07"));
INSERT INTO Sales VALUES (1005, 8, 4, 6, DATE("2021-04-11"));