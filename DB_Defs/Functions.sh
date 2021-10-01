# Robert Bell 010857731 2021-04-21
# Functions called by Food Truck! Database Project

# Get the customer-friendly view for Menu
SELECT name, addon AS 'Combo Addons', price FROM Menu;

# Get the customer-friendly view for Addons
SELECT name, price FROM Addons;

# Get the gross profit of all sales on a certain day
SELECT SUM(COALESCE(mainprice, 0)) + SUM(COALESCE(addon1price, 0)) + SUM(COALESCE(price, 0)) AS 'sum'
FROM (SELECT itemid, addon1id, addon2id, saledate, mainprice, price AS 'addon1price'
        FROM (SELECT itemid, addon1id, addon2id, price AS 'mainprice', saledate
            FROM Menu
            INNER JOIN Sales ON Menu.id=Sales.itemid
        ) AS X
    INNER JOIN Addons ON X.addon1id=Addons.id
    ) AS Y
LEFT JOIN Addons ON Y.addon2id=Addons.id
WHERE saledate='2021-04-05'
;

# Delete a record from SALES based on date of sale *narrow use*
# *better is name reference from main table + sale date, but for 
# now we delete a day of records*
DELETE FROM Sales 
WHERE saledate='2021-04-01'
;

# Add an employee record to DB / Extract largest employeeID and append one larger in java
SELECT id
FROM Employees
ORDER BY id DESC
LIMIT 1
;

# Create a new sale item in DB / Extract largest transID and append one larger in java
SELECT transid
FROM Sales
ORDER BY transid DESC
LIMIT 1
;

# Retrieve id for Menu item on name
SELECT id
FROM Menu
WHERE name='Mixed Fajitas'
;

# Retrieve id for Addons item on name
SELECT id
FROM Addons
WHERE name='Pico de Gaillo'
;