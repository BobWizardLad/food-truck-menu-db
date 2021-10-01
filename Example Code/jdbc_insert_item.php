<html>
<body>
<h3>Enter information about an item to add to the database:</h3>

<form action="jdbc_insert_item.php" method="post">
    Name: <input type="text" name="name"><br>
    Price_Per_LB: <input type="text" name="price_per_lb"><br>
    Roasting: <input type="text" name="roasting"><br>
    <input name="submit" type="submit" >
</form>
<br><br>

</body>
</html>

<?php
if (isset($_POST['submit'])) 
{
    // replace ' ' with '\ ' in the strings so they are treated as single command line args
    $name = escapeshellarg($_POST[name]);
    $price_per_lb = escapeshellarg($_POST[price_per_lb]);
    $roasting = escapeshellarg($_POST[roasting]);

    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar jdbc_insert_item ' . $name . ' ' . $price_per_lb . ' ' . $roasting;

    // remove dangerous characters from command to protect web server
    $escaped_command = escapeshellcmd($command);
    echo "<p>command: $command <p>"; 
    // run jdbc_insert_item.exe
    system($escaped_command);           
}
?>


