
<?php
 $con=mysql_connect("localhost","root","");
 
 if(!$con)
 die('could not connect: ' .mysql_error());
 
 mysql_select_db("nozadb",$con);
 
$result = mysql_query("SELECT * FROM citizens where RGBinstitution ='International organizations' ");
 while($row=mysql_fetch_assoc($result)){
 $output[]=$row;
}
 print(json_encode($output));

 mysql_close($con); 
 
 ?>
  