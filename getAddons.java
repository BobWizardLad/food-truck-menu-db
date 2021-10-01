// Robert Bell 010857731 2021-04-21
// Class called by site to retrieve Addons table from DB for Food Truck!
import java.sql.*;

public class getAddons {
    public static void main(String args[]) throws SQLException {
        // Connect to DB
        jdbc_db dataBase = new jdbc_db();
        dataBase.connect("robell", "Jousoo3a");
        dataBase.initDatabase();

        // Make query to DB
        String q = "SELECT name, price FROM Addons;";
        String menuQuery = dataBase.query(q);

        // Return result appropriately
        System.out.println(menuQuery);

        // Close connection
        dataBase.disConnect();
    }
}
