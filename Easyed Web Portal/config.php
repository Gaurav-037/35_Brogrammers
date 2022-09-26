<?php
/*
This file contains database configuration assuming you are running mysql using user "root" and password ""
*/

define('server', 'localhost');
define('username', 'root');
define('pass', '');
define('db_name', 'login');

// Try connecting to the Database
$conn = mysqli_connect(server, username, pass, db_name);

//Check the connection
if($conn == false){
    dir('Error: Cannot connect');
}

?>