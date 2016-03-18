<?php
$hostname_localhost ="localhost";
$database_localhost ="nozadb";
$username_localhost ="root";
$password_localhost ="";
$localhost = mysql_connect($hostname_localhost,$username_localhost,$password_localhost)
or
trigger_error(mysql_error(),E_USER_ERROR);
 
mysql_select_db($database_localhost, $localhost);

$tel = $_POST['tel'];
$password = $_POST['password'];
$password = $_POST['password'];
$query_search = "select * from users where tel = '".$tel."' AND password = '".$password. "' AND email = '".$email. "' ";
$query_exec = mysql_query($query_search) or die(mysql_error());
$rows = mysql_num_rows($query_exec);
//echo $rows;
 if($rows == 0) { 
 echo "No Such User Found"; 
 }
 else  {
    echo "User Found"; 
}
?>