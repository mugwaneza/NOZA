<?php
class USER
{
	private $db;
	
	function __construct($DB_con)
	{
		$this->db = $DB_con;
	}
	
	public function register($uname,$umail,$upass)
	{
		try
		{
			$new_password = password_hash($upass, PASSWORD_DEFAULT);
			
			$stmt = $this->db->prepare("INSERT INTO rgbstaff(user_name,user_email,user_pass) 
		                                               VALUES(:uname, :umail, :upass)");
												  
			$stmt->bindparam(":uname", $uname);
			$stmt->bindparam(":umail", $umail);
			$stmt->bindparam(":upass", $new_password);
				
			$stmt->execute();
			
			return $stmt;	
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}				
	}
	public function give_comment($org,$comm)
	{
		try
		{
			$stmt = $this->db->prepare("INSERT INTO comments_given(Organization,Comments_giv) 
		                                               VALUES(:org, :comm)");
												  
			$stmt->bindparam(":org", $org);
			$stmt->bindparam(":comm", $comm);
				
			$stmt->execute();
			
			return $stmt;	
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}				
	}
	
	public function login($uname,$umail,$upass)
	{
		try
		{
			$stmt = $this->db->prepare("SELECT * FROM rgbstaff WHERE user_name=:uname OR user_email=:umail LIMIT 1");
			$stmt->execute(array(':uname'=>$uname, ':umail'=>$umail));
			$userRow=$stmt->fetch(PDO::FETCH_ASSOC);
			if($stmt->rowCount() > 0)
			{
				if(password_verify($upass, $userRow['user_pass']))
				{
					$_SESSION['user_session'] = $userRow['user_id'];
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}
	}
	public function report($location_time,$dt,$tm,$Reason,$institution,$Description)
	{
		try
		{
			$stmt = $this->db->prepare("INSERT INTO citizens(location, mydate, mytime, why, RGBinstitution, mytext) 
		                                               VALUES(:location, :mydate, :mytime, :why, :RGBinstitution, :mytext)");
												  
			$stmt->bindparam(":location", $location_time);
			$stmt->bindparam(":mydate", $dt);
			$stmt->bindparam(":mytime", $tm);
			$stmt->bindparam(":why", $Reason);
			$stmt->bindparam(":RGBinstitution", $institution);
			$stmt->bindparam(":mytext",$Description);
				
			$stmt->execute();
			
			return $stmt;	
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}				
	}
	public function is_loggedin()
	{
		if(isset($_SESSION['user_session']))
		{
			return true;
		}
	}
	
	public function redirect($url)
	{
		header("Location: $url");
	}
	
	
	public function logout()
	{
		session_destroy();
		unset($_SESSION['user_session']);
		unset($_SESSION['user_cat']);
		return true;
	}
}
?>