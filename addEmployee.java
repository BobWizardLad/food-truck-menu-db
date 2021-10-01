// Robert Bell 010857731 2021-04-21
// Class called by site to handle insertion into Employees table of DB for Food Truck!
import java.sql.*;

public class addEmployee {
    public static void main(String[] args) throws SQLException {
        // Connect to DB
        jdbc_db dataBase = new jdbc_db();
        dataBase.connect("robell", "Jousoo3a");
        dataBase.initDatabase();

        // Extract transactionID from DB and build new query
        String q = "SELECT id FROM Employees ORDER BY id DESC LIMIT 1;";
        int newID = Integer.parseInt(dataBase.getQueryRecords(q, 1)) + 1;

        // Create tuple and put on DB
        String insertDat = newID + ", \"" + args[0] + "\", \"" + args[1] + "\", " + args[2] + ", \"" + args[3] + "\"";
        dataBase.insert("Employees", insertDat);

        // Close connection
        System.out.println("New employee:");
        System.out.println(dataBase.query("SELECT * FROM Employees WHERE id=" + newID + ";"));
        dataBase.disConnect();
    }
}
