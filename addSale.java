// Robert Bell 010857731 2021-04-21
// Class called by site to handle creating a sales entry
import java.sql.*;

public class addSale {
    // args[0] = menu item name, args[1] = addon1 name, args[2] = addon2 name
    // args[3] = sale date yyyy-mm-dd
    public static void main(String[] args) throws SQLException {
        // Connect to DB
        jdbc_db dataBase = new jdbc_db();
        dataBase.connect("robell", "Jousoo3a");
        dataBase.initDatabase();

        // Extract transactionID from DB and build new query
        String q = "SELECT transid FROM Sales ORDER BY transid DESC LIMIT 1;";
        int newID = Integer.parseInt(dataBase.getQueryRecords(q, 1)) + 1;

        // Get id and addon from Menu
        q = "SELECT id, addon FROM Menu WHERE name=\'" + args[0] + "\';";
        String menuResult = dataBase.getQueryRecords(q, 2);
        String[] temp = menuResult.split(" ");
        String menuId = temp[0];
        int addons = Integer.parseInt(temp[1]);
        String addon2Id;

        // Get ids from Addons, based on addon attribute of Menu item
        q = "SELECT id FROM Addons WHERE name=\'" + args[1] + "\';";
        String addon1Id = dataBase.getQueryRecords(q, 1);
        if (addons == 2) {
            q = "SELECT id FROM Addons WHERE name=\'" + args[1] + "\';";
            addon2Id = dataBase.getQueryRecords(q, 1);
        } else {
            addon2Id = "NULL";
        }

        // Create tuple and put on DB
        String insertDat = newID + ", " + menuId + ", " + addon1Id + ", " + addon2Id + ", DATE(\"" + args[3] + "\")";
        dataBase.insert("Sales", insertDat);

        // Close connection
        System.out.println("Sale recorded!");
        dataBase.disConnect();
    }
}
