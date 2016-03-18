<?php
class USER
{
	private $db;
	
	function __construct($DB_con)
	{
		$this->db = $DB_con;
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
}
?>