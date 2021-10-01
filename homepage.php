<html>
<head>
    <title>Food Truck!</title> 
    <link rel="icon" type="image/gif/png" href="icon.jpg">
</head>
<body style="background-color: LightGoldenRodYellow">

    <div style="height: 400px; column-count: 2;">
        <h1>Food Truck!</h1>

        <form action="homepage.php" method="POST">
            <input type="submit" name="getAllMenu" value="Get The Full Menu">
        </form>

        <form action="homepage.php" method="POST">
            <input type="submit" name="getMenu" value="Get Our Mains Menu">
        </form>

        <form action="homepage.php" method="POST">
            <input type="submit" name="getAddons" value="Get Our Addons Menu">
        </form>

        <h2>Daily Sales Value</h2>
        <form action="homepage.php" method="POST">
            Date:<input type="text" name="valueDate" value="">
            <input type="submit" name="salesValue" value="Get Sales Value">
        </form>

        <h2>Delete Sales by Day</h2>
        <form action="homepage.php" method="POST">
            Date:<input type="text" name="deleteSaleDate" value="">
            <input type="submit" name="cancelSale" value="Cancel Sales Day">
        </form>

        <h2>Make A New Sale</h2>
        <form action="homepage.php" method="POST">
            Menu Item:<input type="text" name="menuName" value=""><br>
            Addon 1:<input type="text" name="addon1Name" value=""><br>
            Addon 2:<input type="text" name="addon2Name" value=""><br>
            Date of Sale:<input type="text" name="saleDate" value=""><br>
            <input type="submit" name="addSale" value="Submit Transaction">
        </form>

        <h2>Register A New Employee</h2>
        <form action="homepage.php" method="POST">
            Employee Name:<input type="text" name="name" value=""><br>
            Employee Occupation:<input type="text" name="occupation" value=""><br>
            Employee Phone Number:<input type="text" name="phoneNum" value=""><br>
            Employee Address City:<input type="text" name="addr" value=""><br>
            <input type="submit" name="addEmployee" value="Submit Employee Addition">
        </form>
    </div>
    <br><br>

</body>
</html>

<?php
# Call to get both menu tables using each command on second condition for easier form filling
# Call to get menu table
if (!empty(isset($_POST['getMenu'])) or !empty(isset($_POST['getAllMenu']))) {
    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar getMenu';

    $command = escapeshellcmd($command);
    
    echo "command: $command <br>";
    system($command);
}
# Call to get addons table
if (!empty(isset($_POST['getAddons'])) or !empty(isset($_POST['getAllMenu']))) {
    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar getAddons';

    $command = escapeshellcmd($command);
    
    echo "command: $command <br>";
    system($command);
}
# Call to add an employee record
elseif (!empty(isset($_POST['addEmployee']))) {
    $name = escapeshellarg($_POST[name]);
    $occupation = escapeshellarg($_POST[occupation]);
    $phoneNum = escapeshellarg($_POST[phoneNum]);
    $addr = escapeshellarg($_POST[addr]);
    
    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar addEmployee ' . $name . ' ' . $occupation . ' ' . $phoneNum . ' ' . $addr;

    $command = escapeshellcmd($command);
    
    echo "command: $command <br>";
    system($command);
}
# Call to get the sales value for all sales on day of valueDate
elseif (!empty(isset($_POST['salesValue']))) {
    $date = escapeshellarg($_POST[valueDate]);

    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar salesValue ' . $date;

    $command = escapeshellcmd($command);
    
    echo "command: $command <br>";
    system($command);

}
# Call to delete a record from Sales
elseif (!empty(isset($_POST['cancelSale']))) {
    $date = escapeshellarg($_POST[deleteSaleDate]);

    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar cancelSale ' . $date;

    $command = escapeshellcmd($command);
    
    echo "command: $command <br>";
    system($command);
}
# Call to add a new Sales record
elseif (!empty(isset($_POST['addSale']))) {
    $menu = escapeshellarg($_POST[menuName]);
    $addon1 = escapeshellarg($_POST[addon1Name]);
    $addon2 = escapeshellarg($_POST[addon2Name]);
    $date = escapeshellarg($_POST[saleDate]);

    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar addSale ' . $menu . ' ' . $addon1 . ' ' . $addon2 . ' ' . $date;

    $command = escapeshellcmd($command);
    
    echo "command: $command <br>";
    system($command);
}
?>