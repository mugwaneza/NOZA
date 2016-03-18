<?php 
    //for africastalking
    $phonenumber = $_GET['MSISDN'];
    $sessionID = $_GET['sessionId'];
    $servicecode = $_GET['serviceCode'];
    $ussdString = $_GET['text'];
    
    //create data fields
    $regNo="";
    $fName="";
    $lName="";
    $gender="";
    $genderV="";
    $pass="";
    $acceptDeny="";
    $username="";
    $password="";
    $year="";
    $semester="";
	function one($one){
	switch ($one[0])
        {
            case 1:
                if(count($one)>1){
				$myone= two($one);
				}else{
				$myone='wow';
				}
                break;
            case 2:
                if(count($one)>1){
				$myone='wow';
				}else{
				$myone='wow';
				}
                break;
        }
		return $myone;
	}
	
	function two($two){
	switch ($two[1])
        {
            case 1:
                if(count($two)>2){
				$myone='wowow2';
				}else{
				$myone='wow2';
				}
                break;
            case 2:
                if(count($two)>2){
				$myone='wow2';
				}else{
				$myone='wow2';
				}
                break;
        }
		return $mytwo;
	}
	
	
	
	
	
	
	"Select Reason <br/>1. POOR SERVICE <br/> 2. CORRUPTION <br/>3. ASK RGB <br/>4. RETURN <br/>";
	
	
	
	
	
	
	
	
	
	
	if ($details[1]==1){
				$ussd_text="RGB<br/> Enter your Location";
				ussd_proceed($ussd_text);
			}
			else{
				header("Location: ucuresults.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=");
			}
?>