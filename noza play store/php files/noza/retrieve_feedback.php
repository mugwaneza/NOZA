<?php

	$con=mysql_connect("localhost","root","");
 
 if(!$con)
 die('could not connect: ' .mysql_error());
	mysql_select_db("nozadb",$con);
	$sql = "SELECT * FROM policefeedback";
	$result = mysql_query("SET NAMES UTF8");
	$result = mysql_query($sql);
	$int_num_field = mysql_num_fields($result);
	$json = array();
	
	while($row = mysql_fetch_array($result)){
		
		$arr_col = array();
		for($i=0;$i<$int_num_field;$i++){
			$arr_col[mysql_field_name($result,$i)] = $row[$i];
		}
		array_push($json,$arr_col);
		
	}
	mysql_close($con);
	header('Content-type: text/json');
	echo json_encode($json);
	
?>