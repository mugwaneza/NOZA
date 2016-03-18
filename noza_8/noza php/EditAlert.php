<?php
$mysqlConnect = mysql_connect("localhost","root","");
$mysqlDB = mysql_select_db("nozadb");

// array for JSON response
$response = array();

// check for post data
if (isset($_GET["identity"])) {
    $identity = $_GET['identity'];
 
    // get a product from citizens table
    $result = mysql_query("SELECT *FROM citizens WHERE identity = $identity");
 
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {
 
            $result = mysql_fetch_array($result);
 
            $product = array();
            $product["identity"] = $result["identity"];
            $product["location"] = $result["location"];
            $product["price"] = $result["price"];
            $product["date"] = $result["date"];
            $product["time"] = $result["time"];
            $product["why"] = $result["why"];
			$product["RGBinsttitution"] = $result["RGBinstitution"];
			$product["text"] = $result["text"];
 // success
            $response["success"] = 1;
 
            // user node
            $response["product"] = array();
 
            array_push($response["product"], $product);
 
            // echoing JSON response
            echo json_encode($response);
        } else {
            // no product found
            $response["success"] = 0;
            $response["message"] = "No product found";
 
            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No product found";
 
        // echo no users JSON
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