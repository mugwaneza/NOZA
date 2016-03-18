<?php
 
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['head']) && isset($_POST['who']) && isset($_POST['message']) ){
 
    $head = $_POST['head'];
    $who = $_POST['who'];
   $message = $_POST['message'];
   
    
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO policefeedback(head, who, message) VALUES('$head', '$who', '$message')");
 
    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response[""] = "account successfully created.";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response[""] = "Oops! account not created.";
 
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response[""] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}

?>