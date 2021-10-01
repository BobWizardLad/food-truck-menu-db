import java.sql.*;

/*
jdbc_insert_item.java    // java program that is called by php that just does the insert; calls jdbc_db.java to connect and do the actual insert
jdbc_db.java // class (no main program) that has useful methods
*/

public class jdbc_insert_item 
{
   // The main program that inserts a restaurant
   public static void main(String[] args) throws SQLException 
   {
   String Username = "YOURMYSQLUSERNAME";              // Change to your own username
   String mysqlPassword = "YOURMYSQLPASS";    // Change to your own mysql Password

      // Connect to the database
      jdbc_db myDB = new jdbc_db();
      myDB.connect(Username, mysqlPassword);
      myDB.initDatabase();				    

      // For debugging purposes:  Show the database before the insert
      StringBuilder builder = new StringBuilder();
      String query1 = "SELECT * from ITEM";
      builder.append("<br> Table ITEM before:" + myDB.query(query1) + "<br>");       

      // Parse input string to get restauranrestaurant Name and Address
      String id = "23";
      String name = "name";
      String price_per_lb = "price_per_lb";
      String roasting = "roasting";

      // Read command line arguments
      // args[0] is the first parameter
      name = args[0];
      price_per_lb = args[1];
      roasting = args[2];

      // Insert the new restaurant
      String input = id + ",'" + name + "','" + price_per_lb + "','" + roasting + "'";               
      myDB.insert("ITEM", input);    // insert new restaurant

      // For debugging purposes:  Show the database after the insert
      builder.append("<br><br><br> Table ITEM after:" + myDB.query(query1));
      System.out.println(builder.toString());     

      myDB.disConnect();
   }
}
