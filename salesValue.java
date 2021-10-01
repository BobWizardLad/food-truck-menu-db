// Robert Bell 010857731 2021-04-21
// Class called by site to get the total value of sales on a parameter day
import java.sql.*;

public class salesValue {
    public static void main(String[] args) throws SQLException {
        // Connect to DB
        jdbc_db dataBase = new jdbc_db();
        dataBase.connect("robell", "Jousoo3a");
        dataBase.initDatabase();

        // Include args[0] (sales date) into query
        String q = 
        "SELECT SUM(COALESCE(mainprice, 0)) + SUM(COALESCE(addon1price, 0)) + SUM(COALESCE(price, 0)) AS \'sum\' " +
        "FROM (SELECT itemid, addon1id, addon2id, saledate, mainprice, price AS \'addon1price\' " +
        "FROM (SELECT itemid, addon1id, addon2id, price AS \'mainprice\', saledate " +
        "FROM Menu " +
        "INNER JOIN Sales ON Menu.id=Sales.itemid " +
        ") AS X " +
        "INNER JOIN Addons ON X.addon1id=Addons.id " +
        ") AS Y " +
        "LEFT JOIN Addons ON Y.addon2id=Addons.id " +
        "WHERE saledate=\'" + args[0] + "\';";

        String result = dataBase.query(q);

        // Print query to console
        System.out.println(result);

        // Disconnect
        dataBase.disConnect();
    }
}
