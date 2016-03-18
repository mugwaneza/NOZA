<?php
define('HOST','localhost');
define('USER','root');
define('PASS','');
define('DB','nozadb');
 
$con = mysqli_connect(HOST,USER,PASS,DB);
 
$sql = "select id,comment,date from landregistration";
$sql1 ="select sum(rates) rates from landregistration";
$res = mysqli_query($con,$sql);
 $res1 = mysqli_query($con,$sql1);
$result1 = array();

 $row1= mysqli_fetch_array($res1);
 array_push($result1,array('rates'=>$row1 [0]));
 
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,
array('id'=>$row[0],
'comment'=>$row[1],
'date'=>$row[2]
));
}
 
echo json_encode(array("result"=>$result,"result1"=>$result1));
 
mysqli_close($con);
 
?>