
<?php
 
       
                   $con=mysql_connect("localhost","root","");
                  $db=mysql_select_db("nozadb",$con);
				 
                  if($con && $db)
                {
                echo"        ";
                  }
				  else
               {
            die('Could not connect: ' . mysql_error());
                  } 
			if (isset($_POST['comment']) && isset($_POST['rates']) ){

    $comment = $_POST['comment'];
    $rates = $_POST['rates'];
	
	$query=mysql_query("select * from drivinglicense where comment='".$comment."' ") or die(mysql_error());
$duplicate=mysql_num_rows($query);
   if($duplicate==0)
    {
				
      $sql= "insert ignore into drivinglicense(comment, rates) values('$_POST[comment]','$_POST[rates]')";
		}	   
           if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }

}  echo  "  success" ;
     

 ?>
  