<?php
 
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['names']) && isset($_POST['email']) && isset($_POST['tel']) && isset($_POST['age']) && isset($_POST['gender'])  && isset($_POST['district']) && isset($_POST['password']) ) {
 
    $names = $_POST['names'];
    $tel = $_POST['tel'];
	$district = $_POST['email'];
   $age = $_POST['age'];
   $gender = $_POST['gender'];
    $password = $_POST['password'];
	 $district = $_POST['district'];
	 
    
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO users(names, email, tel, age, gender, district, password) VALUES('$names', '$email', '$tel', '$age', '$gender', '$district', '$password')");
 
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