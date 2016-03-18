<?php
 
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['location']) && isset($_POST['time']) && isset($_POST['date']) && isset($_POST['why']) && isset($_POST['RGBinstitution']) && isset($_POST['text'])){
 
    $location = $_POST['location'];
    $time = $_POST['time'];
   $date = $_POST['date'];
   $why = $_POST['why'];
   $RGBinstitution = $_POST['RGBinstitution'];
   $text = $_POST['text'];
    
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO citizens(location, time, date, why, RGBinstitution, text) VALUES('$location', '$time', '$date', '$why', '$RGBinstitution', '$text')");
 
    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "account successfully created.";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! account not created.";
 
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}

?>