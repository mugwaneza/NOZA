
<?php
 
       
                   $con=mysql_connect("localhost","ndanoza_home","amahoro");
                  $db=mysql_select_db("ndanoza_noza",$con);
				 
                  if($con && $db)
                {
                echo"        ";
                  }
				  else
               {
            die('Could not connect: ' . mysql_error());
                  } 
			if (isset($_POST['comment']) && isset($_POST['rates']) && isset($_POST['names']) ){

    $comment = $_POST['comment'];
    $rates = $_POST['rates'];
	 $names= $_POST['names'];
	
	$query=mysql_query("select * from landregistration where comment='".$comment."' ") or die(mysql_error());
$duplicate=mysql_num_rows($query);
   if($duplicate==0)
    {
				
      $sql= "insert ignore into landregistration(comment, rates, names) values('$_POST[comment]','$_POST[rates]','$_POST[names]')";
		}	   
           if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }

}  echo  "  success" ;
     

 ?>
  