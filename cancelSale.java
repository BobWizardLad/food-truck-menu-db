// Robert Bell 010857731 2021-04-21
// Class called by site to handle deletion from Sales table of DB in Food Truck!
import java.sql.SQLException;

public class cancelSale {
    public static void main(String[] args) throws SQLException{
        // Connect to DB
        jdbc_db dataBase = new jdbc_db();
        dataBase.connect("robell", "Jousoo3a");
        dataBase.initDatabase();

        // Create Query from arguments to delete record
        // args[0] = itemid, args[1] = saledate raw string

        String condition = "saledate=\'" + args[0] +"\'";
        dataBase.delete("Sales", condition);

        // Print query confirmation
        System.out.println("Sale Cancelled");

        // Close connection
        dataBase.disConnect();
    }
}
