<?php 
    $phonenumber = $_GET['MSISDN'];
    $sessionID = $_GET['sessionId'];
    $servicecode = $_GET['serviceCode'];
    $ussdString = $_GET['text'];
    
    //N/B: on going live we will change the GET[] method to POST[] (that is how africastalking do their stuff)
    $level =0;
    
    if($ussdString != ""){
            $ussdString=  str_replace("#", "*", $ussdString);
            $ussdString_explode = explode("*", $ussdString);
            $level = count($ussdString_explode);
    }
    if ($level==0){        
        displaymenu();
    }
    function displaymenu(){
        $ussd_text="WELCOME TO RGB <br/>THROUGH NOZA <br/>REPORT CORRUPTION<BR/> REPORT POOR SERVICES<br/><br/>1. to continue<br/>2. Leave your Idea <br/><br/>";
        ussd_proceed($ussd_text);
    }
    function ussd_proceed ($ussd_text){
        echo $ussd_text;
        //exit(0);
    }
    if ($level>0){
        switch ($ussdString_explode[0])
        {
            case 1:
                continue_app($ussdString_explode,$phonenumber);
                break;
            case 2:
                aboutapp($ussdString_explode,$phonenumber);
                break;
            default:
                header("Location: rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=");
                break;
        }
    }
    function continue_app($details,$phone){
        if(count($details) == 7 && $details[4]!=4 && $details[4]!=2){
            $location_time=$details[2];
            $ReasonV=$details[3];
            $institutionV=$details[4];
            $Description=$details[5];
            $acceptDeny=$details[6];
            
            if($ReasonV=="1"){
                $Reason="Poor services";
            }else if($ReasonV=="2"){
                $Reason="Corruption";
            }else if($ReasonV=="3"){
                $Reason="Inquiry";
            }
            if($institutionV=="1"){
                $institution="MINISTRIES";
            }else if($institutionV=="2"){
                $institution="DISTRICTS";
            }
            else if($institutionV=="3"){
                $institution="HEALTH";
            }
            else if($institutionV=="4"){
                $institution="EDUCATION";
            }
            else if($institutionV=="5"){
                $institution="LOWYERS";
            }
            if($acceptDeny=="1"){
                //=================Do your business logic here===========================
		include_once 'dbconfig.php';
            $location_date_time = explode(" ", $location_time);
            if($user->report($location_date_time[0],$location_date_time[2],$location_date_time[1],$Reason,$institution,$Description))	{
					
					echo "Reported<br/> Thank you for using our services.";
				}
                
            }else{//Choice is cancel
                $ussd_text = "END Your session is over";
                ussd_proceed($ussd_text);
            }       
                
        }
        else if(count($details) == 8 && ($details[4]==4 || $details[4]==2)){
            $location_time=$details[2];
            $ReasonV=$details[3];
            $institutionV=$details[4];
            $sub_InstitutionV=$details[5];
            $Description=$details[6];
            $acceptDeny=$details[7];
            
            if($ReasonV=="1"){
                $Reason="Poor services";
            }else if($ReasonV=="2"){
                $Reason="Corruption";
            }else if($ReasonV=="3"){
                $Reason="Inquiry";
            }
            if($institutionV=="1"){
                $institution="MINISTRIES";
            }else if($institutionV=="2"){
                $institution="DISTRICTS";
            }
            else if($institutionV=="3"){
                $institution="HEALTH";
            }
            else if($institutionV=="4"){
                $institution="EDUCATION";
            }
            else if($institutionV=="5"){
                $institution="LOWYERS";
            }
            if($details[4]==4 ){
                if($sub_InstitutionV=="1"){
                $sub_Institution="Primary";
            }else if($sub_InstitutionV=="2"){
                $sub_Institution="Secondary";
            }
            else if($sub_InstitutionV=="3"){
                $sub_Institution="University";
            }
                }else if( $details[4]==2){
                        if($sub_InstitutionV=="1"){
                $sub_Institution="Akarere";
            }else if($sub_InstitutionV=="2"){
                $sub_Institution="Umurenge";
            }
            else if($sub_InstitutionV=="3"){
                $sub_Institution="Akagali";
            }
            else if($sub_InstitutionV=="4"){
                $sub_Institution="Umudugudu";
            }
                }
            if($acceptDeny=="1"){
                //=================Do your business logic here===========================
		include_once 'dbconfig.php';
	    $location_date_time = explode(" ", $location_time);
            if($user->report($location_date_time[0],$location_date_time[2],$location_date_time[1],$Reason,$institution.",".$sub_Institution,$Description)){
					
					echo "Reported<br/> Thank you for using our services.";
				}
                
            }else{//Choice is cancel
                $ussd_text = "END Your session is over";
                ussd_proceed($ussd_text);
            }
            
            
        }else{
			$ussd_text= one($details);
			ussd_proceed($ussd_text);
        }
        
    }
    
    function aboutapp($details,$phone){
        
        if(count($details) == 4 && $details[0]==2 ){
            $OrganisationV=$details[1];
            $Comment=$details[2];
            $Confirmation=$details[3];
	    
	    if($OrganisationV=="1"){
                $Organisation="Political Parties Registration.";
            }
            else if($OrganisationV=="2"){
                $Organisation="NGO Registration";
            }
            else if($OrganisationV=="3"){
                $Organisation="FBO Registration";
            }
	    else if($OrganisationV=="4"){
                $Organisation="Odering Passport";
            }
            else if($OrganisationV=="5"){
                $Organisation="License Driver";
            }
	    else if($OrganisationV=="6"){
                $Organisation="Border Managment";
            }
            if($Confirmation=="1"){
                //=================Do your business logic here===========================
		include_once 'dbconfig.php';
	    if($user->give_comment($Organisation,$Comment)){
					
					echo "Reported<br/> Thank you for using our services.";
				}
            }else{//Choice is cancel
                $ussd_text = "END Your session is over";
                ussd_proceed($ussd_text);
            }
        }else{
        $ussd_text= one($details);
	ussd_proceed($ussd_text);   
                
        }
    }
	//first function
	function one($one){
	switch ($one[0])
        {
            case 1:
                if(count($one)>1){
				$myone= two($one);
				}else{
				$myone='1.Report  to RGB<br/> 2.Cancel a process';
				}
                break;
            case 2:
                if(count($one)>1){
				$myone=two($one);
				}else{
                                $myone='Services Provided by Government of Rwanda<br/><br/> 1.Political Parties Registration.
                                <br/> 2.NGO Registration.<br/> 3.FBO Registration.<br/> 4.Odering Passport.<br/>5.License Driver.<br/>6.Border Managment.';
				}
                break;
        }
		return $myone;
	}
	//second function
	function two($two){
                
        switch ($two[0])
        {
        case 1:
                switch ($two[1])
                {
                    case 1:
                        if(count($two)>2){
                                        $mytwo=three($two);
                                        }else{
                                        $mytwo='Enter your location, Time and Date.';
                                        }
                        break;
                    case 2:
                        header("Location: rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=");
                        break;
                    default:
                        $mytwo=$_GET['text'];
                        $ussdString=  str_replace("#", "*", $_GET['text']);
                        $ussdString_explode = explode("*", $ussdString);
                        $level = count($ussdString_explode);
                        unset($ussdString_explode[$level-1]);
                        $link_part=implode("*",$ussdString_explode);
                        $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                        header("Location: $a");
                        break;
                }
                break;
        case 2:
                if(count($two)>2){
                                $mytwo=three($two);
				}else{
                                        switch($two[1]){
                                                case 1:
                                                case 2:
                                                case 3:
                                                case 4:
                                                case 5:
                                                case 6:
                                                $mytwo="Leave your Comment here";
                                                        break;
                                                default:
                                                        $ussdString=  str_replace("#", "*", $_GET['text']);
                                                        $ussdString_explode = explode("*", $ussdString);
                                                        $level = count($ussdString_explode);
                                                        unset($ussdString_explode[$level-1]);
                                                        $link_part=implode("*",$ussdString_explode);
                                                        $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                                                        header("Location: $a");
                                                        break;
                                                }
				}
                break;
        }
		return $mytwo;
	}
	//third function
	function three($three){
        switch ($three[0])
        {
        case 1:
	if(count($three)>3){
                $mythree=four($three);
	}else if(trim($three[2]," ")!=""){
	$mythree='Select a REASON</BR> 1.Poor Services </br>2.Corruption</br>3.Inquiry.';
	}else{
                $ussdString=  str_replace("#", "*", $_GET['text']);
                $ussdString_explode = explode("*", $ussdString);
                $level = count($ussdString_explode);
                unset($ussdString_explode[$level-1]);
                $link_part=implode("*",$ussdString_explode);
                $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                header("Location: $a");
        }
        break;
        case 2:
                if(count($three)>3){
                                $mythree="Insert there.";
				}else{
                                        if(trim($three[2]," ")!=""){
                                        $mythree="are you sure?</br> 1.SEND <br/>2.CANCEL";
                                        }else{
                                        $ussdString=  str_replace("#", "*", $_GET['text']);
                                        $ussdString_explode = explode("*", $ussdString);
                                        $level = count($ussdString_explode);
                                        unset($ussdString_explode[$level-1]);
                                        $link_part=implode("*",$ussdString_explode);
                                        $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                                        header("Location: $a");     
                                        }
                                        }
                break;
        default:
                $ussdString=  str_replace("#", "*", $_GET['text']);
                $ussdString_explode = explode("*", $ussdString);
                $level = count($ussdString_explode);
                unset($ussdString_explode[$level-1]);
                $link_part=implode("*",$ussdString_explode);
                $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                header("Location: $a");
                break;
        }////////////////////////
	return $mythree;
	}
	//fourth function 
	function four($four){
	switch ($four[3])
        {
            case 1:
                if(count($four)>4){
					$myfour=five($four);
				}else{
				$myfour="Select Public Institution <br/>1. MINISTRIES <br/> 2. DISTRICTS <br/>3. HEALTH <br/>4. EDUCATION <br/>5. LOWYERS";
				}
                break;
            case 2:
				if(count($four)>4)
				{
					$myfour=five($four);
				}else{
				$myfour="Select Public Institution <br/>1. MINISTRIES <br/> 2. DISTRICTS <br/>3. HEALTH <br/>4. EDUCATION <BR/>5. LOWYERS";
				}
				break;
            case 3:
                if(count($four)>4)
				{
					$myfour=five($four);
				}else{
                $myfour="Select Public Institution <br/>1. MINISTRIES <br/> 2. DISTRICTS <br/>3. HEALTH <br/>4. EDUCATION <BR/>5. LOWYERS";
                                }
                                break;
            default :
                $ussdString=  str_replace("#", "*", $_GET['text']);
                $ussdString_explode = explode("*", $ussdString);
                $level = count($ussdString_explode);
                unset($ussdString_explode[$level-1]);
                $link_part=implode("*",$ussdString_explode);
                $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                header("Location: $a");
        }
	return $myfour;
	}
	//fith function
	function five($five){
	
                if(count($five)>5){
				$myfive=six($five);
				}else{
                                        if($five[4]==2 || $five[4]==4){
                                                if($five[4]==2){
                                          $myfive="Choose<br/>1. Intara<br/>2. Akarere<br/>3. Umurenge<br/>4. Akagali<br/>5. Umudugudu";
                                          }else{
                                                $myfive="Choose<br/>1. Primary<br/>2. Secondary<br/>3. University";   
                                          }
                                                }else{
                                                        switch($five[4]){
                                                case 1:
                                                case 3:
                                                case 5:
                                                        $myfive="Enter your REASON <br/>DESCRIPTION<br/>";
                                                        break;
                                                default:
                                                        $ussdString=  str_replace("#", "*", $_GET['text']);
                                                        $ussdString_explode = explode("*", $ussdString);
                                                        $level = count($ussdString_explode);
                                                        unset($ussdString_explode[$level-1]);
                                                        $link_part=implode("*",$ussdString_explode);
                                                        $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                                                        header("Location: $a");
                                                        break;
                                                }
                                }
				}
	return $myfive;
	}
        //sixth function
	function six($six){
	
                if($six[4]==2 || $six[4]==4){
                if(count($six)>6)
                {
                        if(trim($six[6]," ")==""){
                                                        $ussdString=  str_replace("#", "*", $_GET['text']);
                                                        $ussdString_explode = explode("*", $ussdString);
                                                        $level = count($ussdString_explode);
                                                        unset($ussdString_explode[$level-1]);
                                                        $link_part=implode("*",$ussdString_explode);
                                                        $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                                                        header("Location: $a");
                                }else{
				$mysix="are you sure?</br> 1.SEND <br/>2.CANCEL";
                                }
				}else{
                                      switch($six[5]){
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        if($six[4]==2){
                                                $mysix="Enter your REASON <br/>DESCRIPTION<br/>";
                                                        }
                                        else if($six[4]==4){
                                                switch($six[5]){
                                                case 1:
                                                case 2:
                                                case 3:
                                                $mysix="Enter your REASON <br/>DESCRIPTION<br/>";
                                                        break;
                                                default:
                                                        $ussdString=  str_replace("#", "*", $_GET['text']);
                                                        $ussdString_explode = explode("*", $ussdString);
                                                        $level = count($ussdString_explode);
                                                        unset($ussdString_explode[$level-1]);
                                                        $link_part=implode("*",$ussdString_explode);
                                                        $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                                                        header("Location: $a");
                                                        break;
                                                }
                                                        }
                                                         break;
                                                default: 
                                                        $ussdString=  str_replace("#", "*", $_GET['text']);
                                                        $ussdString_explode = explode("*", $ussdString);
                                                        $level = count($ussdString_explode);
                                                        unset($ussdString_explode[$level-1]);
                                                        $link_part=implode("*",$ussdString_explode);
                                                        $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                                                        header("Location: $a");
                                                        break;
                                        
                                        }
				}
                }else{
                if(count($six)>6)
                {
				//$mysix="are you sure?</br> 1.SEND <br/>2.CANCEL";
				}else{
                                        if(trim($six[5]," ")==""){
                                                        $ussdString=  str_replace("#", "*", $_GET['text']);
                                                        $ussdString_explode = explode("*", $ussdString);
                                                        $level = count($ussdString_explode);
                                                        unset($ussdString_explode[$level-1]);
                                                        $link_part=implode("*",$ussdString_explode);
                                                        $a="rgbussdapp.php?serviceCode=*123%23&sessionId=1234DD34&MSISDN=0726172579&text=".$link_part;
                                                        header("Location: $a");
                                }else{
				$mysix="are you sure?</br> 1.SEND <br/>2.CANCEL";
                                }
				}
        }
	return $mysix;
	}
//        function education($six){
//	
//               if($five[4]==2 || $five[4]==4){
//                if(count($six)>7)
//                {
//				//$mysix="are you sure?</br> 1.SEND <br/>2.CANCEL";
//				}else{
//				$mysix="are you sure?</br> 1.SEND <br/>2.CANCEL";
//				}
//                }else{
//                if(count($six)>6)
//                {
//				//$mysix="are you sure?</br> 1.SEND <br/>2.CANCEL";
//				}else{
//				$mysix="are you sure?</br> 1.SEND <br/>2.CANCEL";
//				}
//        }
//	return $mysix;
//	}
?>