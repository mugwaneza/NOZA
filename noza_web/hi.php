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
				 
               $sql= "insert into citizens(identity,location,date,time,why,RGBinstitution,text) values(NULL,'$_POST[location]','$_POST[date]','$_POST[time]','$_POST[why]','$_POST[RGBinstitution]','$_POST[text]')";
           if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  } echo  " Alert successfully sent to RGB and will be seen by their staff.</br>" ;
      echo"<a href='index.html'>Go back</a>";


?>