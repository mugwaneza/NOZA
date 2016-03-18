<html>


<link rel="stylesheet" type="text/css" href="logo.css" />
<link rel="stylesheet" type="text/css" href="BarmenuCitizenpage.css" />

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=true&libraries=places"></script>

    <script type="text/javascript">
        google.maps.event.addDomListener(window, 'load', function () {
            var places = new google.maps.places.Autocomplete(document.getElementById('txtPlaces'));
            google.maps.event.addListener(places, 'place_changed', function () {
                var place = places.getPlace();

            });
        });
    </script>
<body>



<div id =div1>
<table id="Table_01" width="880" height="99" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3">
			<img src="images/barner2_01.gif" width="880" height="77" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/barner2_02.gif" width="771" height="22" alt=""></td>
		<td>
			<label><a href="citizenpage.php" target="_blank">
				<img src="images/barner2_03.gif" width="82" height="17" border="0" alt=""></a></label></td>
		<td rowspan="2">
			<img src="images/barner2_04.gif" width="27" height="22" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/barner2_05.gif" width="82" height="5" alt=""></td>
	</tr>
</table>
</div>

<div id =div2>
<ul id="nav">
<li><a href="index.html"TARGET ="_parent">HOME</a></li>
<li><a href="#">ALERT</a></li>
<li><a href="#">YOUR IDEA</a></li>
    <li>
      <a href="#">ABOUT</a>
      <ul>
        <li>
		<a href="#">Public institutions</a>	
		<ul>
		<li><a href="#">Districs</a></li>
        <li><a href="#">Health</a></li>
        <li><a href="#">Ministries</a></li>
		<li><a href="#">Security</a></li>
		<li><a href="#">Ministries</a></li>
		<li><a href="#">Gov.agencies</a></li>
		</ul>
		</li>
        
      </ul>
    </li>
  </ul>
    </ul>
</div>


<div id = formdiv >

<table   border="0" cellpadding="0" cellspacing="0"  >
 
  <tr>
    <td valign="right"><p style="color:#7FFF00;"><strong> FILL THE FORM & SEND ALERT TO RGB  </strong> </p>
    
    <form     action="hi.php" method="post" style="border: 1px solid #DDD;">
      <label><span class="style7"><br />
      </span></label>
      <table  cellspacing="10" cellpadding="0" style="color:#FFD300">
	  
        
        <tr>
          <td ><label     >
            <input type="text" name="location" id="txtPlaces" placeholder="Enter your location"   style="width: 300px; height:30px;text-indent:30px; background: white url(img/gmarker5.png) left no-repeat;"  required />
          </label></td>
        </tr>
		
		<tr>
          
          <td>
     <input type="date" name="date" id="funkystyling2"  style="width: 300px; height:30px;" />
	 </br>Set current date*</td>
        </tr>
		
		
        <tr>
          
          <td><label style="width:80px;" >
            <input type="time" name="time"  id="funkystyling3" style="width: 300px; height:30px; "  required />
          </label></br>Set current time*</td>
        </tr>
        
        
       
		 <tr>
          
          <td><select required="required" name="why" onchange="MM_jumpMenu('parent',this,0)" style="width: 300px; height:30px; text-indent:17px;" >
		   <option value="">None</option>
            <option value="Poor service" >Poor service</option>
			<option value="Corruption" >Corruption</option>
			<option value="Inquiry" >Inquiry</option>
			
          </select></br>Select reason*</td>
        </tr>
		
		
        <tr>
          
          <td><select required="required" name="RGBinstitution" onchange="MM_jumpMenu('parent',this,0)"  style="width: 300px; height:30px; text-indent:17px;" >
		     <option value="">None</option>
            <option value="District">District </option>
			<option value="Health">Health</option>
			<option value="Security">Security</option>
			<option value="Ministries">Ministries</option>
			<option value="Gov.agencies">Gov.agencies</option>
			<option value="Lawyers">Lawyers</option>
			<option value="Education">Education</option>
			
          </select></br>Select institution*</td>
        </tr>
        <tr>
          <td ><label >
          <textarea   required="required" name="text"  placeholder="  short description 
		                                                                 of Service provider ."  
		  style="width: 200px; height:80px; margin-left:50px;  maxlength=25;"></textarea>
          </label></br> </br> </td>
        </tr>
        <tr>
          <td margin-letf= "10"><label>
            <input type="submit" name="Submit" value="Alert"  style="width: 52px; height:30px; margin-left:95px;" />
            <input type="reset" name="Submit2" value="Cancel" style="width: 52px;height:30px;"/>
          </label></td>
        </tr>
      </table>
        
      </form>  
</table>	  
	  </div>
	  
	  
	  <div id =footer>

<table id="Table_01" width="881" height="80" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="7">
			<img src="images/footer_01.gif" width="880" height="45" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="45" alt=""></td>
	</tr>
	<tr>
		<td rowspan="5">
			<img src="images/footer_02.gif" width="30" height="35" alt=""></td>
		<td rowspan="2">
			<a href="www.facebook.com" target="_blank">
				<img src="images/footer_03.gif" width="23" height="26" border="0" alt=""></a></td>
		<td colspan="5">
			<img src="images/footer_04.gif" width="827" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="1" alt=""></td>
	</tr>
	<tr>
		<td rowspan="4">
			<img src="images/footer_05.gif" width="12" height="34" alt=""></td>
		<td rowspan="2">
			<a href="www.twitter.com" target="_blank">
				<img src="images/footer_06.gif" width="23" height="29" border="0" alt=""></a></td>
		<td rowspan="4">
			<img src="images/footer_07.gif" width="13" height="34" alt=""></td>
		<td rowspan="3">
			<a href="www.youtube.com" target="_blank">
				<img src="images/footer_08.gif" width="25" height="30" border="0" alt=""></a></td>
		<td rowspan="4">
			<img src="images/footer_09.gif" width="754" height="34" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="25" alt=""></td>
	</tr>
	<tr>
		<td rowspan="3">
			<img src="images/footer_10.gif" width="23" height="9" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="4" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/footer_11.gif" width="23" height="5" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="1" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/footer_12.gif" width="25" height="4" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="4" alt=""></td>
	</tr>
</table>
</div>
	  
  
</body>
</html>