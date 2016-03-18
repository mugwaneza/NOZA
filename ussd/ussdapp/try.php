<?php

if(isset($_POST['edit_butt']))
{
	$Column = trim($_POST['hold_field']);
	$edId = trim($_POST['hold_id']);
	$editVal=trim($_POST['edit']);
	if($Column=="")	{
		$error[] = "error occured !";	
	}
	else if($edId=="")	{
		$error[] = "error occured !";	
	}
	else if($editVal=="")	{
		$error[] = "please give values !";	
	}
	else
	{
		try
		{
			$stmt = $DB_con->prepare("update violance set :column=:col where ID=:edId");
												  
			$stmt->bindparam(":column", $Column);
			$stmt->bindparam(":col", $editVal);
			$stmt->bindparam(":edId", $edId);
			
			$stmt->execute();
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}
		
	}	
}


?>

