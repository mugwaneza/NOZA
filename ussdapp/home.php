<?php
include_once 'dbconfig.php';
if(!$user->is_loggedin())
{
	$user->redirect('index.php');
}
$user_id = $_SESSION['user_session'];
$stmt = $DB_con->prepare("SELECT * FROM users WHERE user_id=:user_id");
$stmt->execute(array(":user_id"=>$user_id));
$userRow=$stmt->fetch(PDO::FETCH_ASSOC);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- TemplateBeginEditable name="doctitle" -->
<title>Login : cleartuts</title>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" -->
<!-- TemplateEndEditable -->
<style type="text/css">
<!--
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background: #4E5869;
	margin: 0;
	padding: 0;
	color: #000;
}

/* ~~ Element/tag selectors ~~ */
ul, ol, dl { /* Due to variations between browsers, it's best practices to zero padding and margin on lists. For consistency, you can either specify the amounts you want here, or on the list items (LI, DT, DD) they contain. Remember that what you do here will cascade to the .nav list unless you write a more specific selector. */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* removing the top margin gets around an issue where margins can escape from their containing div. The remaining bottom margin will hold it away from any elements that follow. */
	padding-right: 15px;
	padding-left: 15px; /* adding the padding to the sides of the elements within the divs, instead of the divs themselves, gets rid of any box model math. A nested div with side padding can also be used as an alternate method. */
}
a img { /* this selector removes the default blue border displayed in some browsers around an image when it is surrounded by a link */
	border: none;
}

/* ~~ Styling for your site's links must remain in this order - including the group of selectors that create the hover effect. ~~ */
a:link {
	color:#414958;
	text-decoration: underline; /* unless you style your links to look extremely unique, it's best to provide underlines for quick visual identification */
}
a:visited {
	color: #4E5869;
	text-decoration: underline;
}
a:hover, a:active, a:focus { /* this group of selectors will give a keyboard navigator the same hover experience as the person using a mouse. */
	text-decoration: none;
}

/* ~~ this container surrounds all other divs giving them their percentage-based width ~~ */
.container {
	width: 80%;
	max-width: 1260px;/* a max-width may be desirable to keep this layout from getting too wide on a large monitor. This keeps line length more readable. IE6 does not respect this declaration. */
	min-width: 780px;
	margin: 0 auto; /* the auto value on the sides, coupled with the width, centers the layout. It is not needed if you set the .container's width to 100%. */
	background-color: #066;
	color: #FFF;
}

/* ~~the header is not given a width. It will extend the full width of your layout. It contains an image placeholder that should be replaced with your own linked logo~~ */
.header {
	background: #6F7D94;
}
.log-form{
	height: auto;
	width: 250px;
}
.log-form form{
	height: auto;
	width: 250px;
}
#form1 input {
	padding: 2px;
	height: 30px;
	width: 200px;
	font-family: "Comic Sans MS", cursive;
	font-weight: normal;
	font-variant: normal;
}
#form1 button {
	padding: 2px;
	height: 30px;
	width: 208px;
	font-family: "Comic Sans MS", cursive;
	font-weight: normal;
	font-variant: normal;
}
/* ~~ This is the layout information. ~~ 

1) Padding is only placed on the top and/or bottom of the div. The elements within this div have padding on their sides. This saves you from any "box model math". Keep in mind, if you add any side padding or border to the div itself, it will be added to the width you define to create the *total* width. You may also choose to remove the padding on the element in the div and place a second div within it with no width and the padding necessary for your design.

*/
.my-table{
    border: 1px solid white;
}
th.my-table,td.my-table{padding: 3px;}
.my-table{border-collapse: collapse;}
.content {
	padding: 10px 0;
}

/* ~~ This grouped selector gives the lists in the .content area space ~~ */
.content ul, .content ol { 
	padding: 0 15px 15px 40px; /* this padding mirrors the right padding in the headings and paragraph rule above. Padding was placed on the bottom for space between other elements on the lists and on the left to create the indention. These may be adjusted as you wish. */
}

/* ~~ The footer ~~ */
.footer {
	padding: 10px 0;
	background: #6F7D94;
}

/* ~~ miscellaneous float/clear classes ~~ */
.fltrt {  /* this class can be used to float an element right in your page. The floated element must precede the element it should be next to on the page. */
	float: right;
	margin-left: 8px;
}
.fltlft { /* this class can be used to float an element left in your page. The floated element must precede the element it should be next to on the page. */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* this class can be placed on a <br /> or empty div as the final element following the last floated div (within the #container) if the #footer is removed or taken out of the #container */
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}
-->
</style></head>

<body>

<div class="container">
  <div class="header"><a href="#"><img src="" alt="Insert Logo Here" name="Insert_logo" width="20%" height="90" id="Insert_logo" style="background: #8090AB; display:block;" /></a> 
    <!-- end .header --></div>
  <div class="content">
    <h1>RGB officiels web</h1>
    <div class="right">
    	<label><a href="logout.php?logout=true" style="color: #fff;"><i class="glyphicon glyphicon-log-out"></i> logout</a></label>
    </div>
    <br/>
<form action="" method="post">
<input type="submit" name="inquiry" value="Inquiry" />
<input type="submit" name="services" value="Poor services" />
<input type="submit" name="corruption" value="Corruption" />
<!--<input type="submit" name="" value="" />-->
</form>
</br>
<?php
include_once 'dbconfig.php';

if(isset($_POST['services'])){
        $stmt = $DB_con->prepare("SELECT * FROM citizens where why=:why");
	$stmt->execute(array(":why"=>"Poor services"));
	$stmt1 = $DB_con->prepare("SELECT * FROM citizens where why=:why");
	$stmt1->execute(array(":why"=>"Poor services"));
if($userRow1=$stmt1->fetch(PDO::FETCH_ASSOC)){
echo "
	<table class='my-table'>
                        <tr>
				<th class='my-table'>Location</th>
				<th class='my-table'>Time</th>
				<th class='my-table'>Date</th>
				<th class='my-table'>Type of Report</th>
				<th class='my-table'>Institution</th>
				<th class='my-table'>Comments</th>
			</tr>";
while($userRow=$stmt->fetch(PDO::FETCH_ASSOC)) {
            echo "
                <tr>
                    <td class='my-table'>{$userRow['location']}</td>
                    <td class='my-table'>{$userRow['mytime']}</td>
                    <td class='my-table'>{$userRow['mydate']}</td>
                    <td class='my-table'>{$userRow['why']}</td>
                    <td class='my-table'>{$userRow['RGBinstitution']}</td>
                    <td class='my-table'>{$userRow['mytext']}</td>
                </tr>";
        }
echo "</table>";
}
}
else if(isset($_POST['corruption'])){
    
    
    $stmt = $DB_con->prepare("SELECT * FROM citizens where why=:why");
	$stmt->execute(array(":why"=>"Corruption"));
	$stmt1 = $DB_con->prepare("SELECT * FROM citizens where why=:why");
	$stmt1->execute(array(":why"=>"Corruption"));
if($userRow1=$stmt1->fetch(PDO::FETCH_ASSOC)){
echo "
	<table class='my-table'>
                        <tr>
				<th class='my-table'>Location</th>
				<th class='my-table'>Time</th>
				<th class='my-table'>Date</th>
				<th class='my-table'>Type of Report</th>
				<th class='my-table'>Institution</th>
				<th class='my-table'>Comments</th>
			</tr>";
while($userRow=$stmt->fetch(PDO::FETCH_ASSOC)) {
            echo "
                <tr>
                    <td class='my-table'>{$userRow['location']}</td>
                    <td class='my-table'>{$userRow['mytime']}</td>
                    <td class='my-table'>{$userRow['mydate']}</td>
                    <td class='my-table'>{$userRow['why']}</td>
                    <td class='my-table'>{$userRow['RGBinstitution']}</td>
                    <td class='my-table'>{$userRow['mytext']}</td>
                </tr>";
        }
echo "</table>";
}

}
else{
    
    $stmt = $DB_con->prepare("SELECT * FROM citizens where why=:why");
	$stmt->execute(array(":why"=>"Inquiry"));
	$stmt1 = $DB_con->prepare("SELECT * FROM citizens where why=:why");
	$stmt1->execute(array(":why"=>"Inquiry"));
if($userRow1=$stmt1->fetch(PDO::FETCH_ASSOC)){
echo "
	<table class='my-table'>
                        <tr>
				<th class='my-table'>Location</th>
				<th class='my-table'>Time</th>
				<th class='my-table'>Date</th>
				<th class='my-table'>Type of Report</th>
				<th class='my-table'>Institution</th>
				<th class='my-table'>Comments</th>
			</tr>";
while($userRow=$stmt->fetch(PDO::FETCH_ASSOC)) {
            echo "
                <tr>
                    <td class='my-table'>{$userRow['location']}</td>
                    <td class='my-table'>{$userRow['mytime']}</td>
                    <td class='my-table'>{$userRow['mydate']}</td>
                    <td class='my-table'>{$userRow['why']}</td>
                    <td class='my-table'>{$userRow['RGBinstitution']}</td>
                    <td class='my-table'>{$userRow['mytext']}</td>
                </tr>";
        }
echo "</table>";
}

}
?>
<p>
    <label>Grant access to the other user. <a href="sign-up.php" style="color: #fff;">Sign Up</a></label>
</p>
<p>&nbsp;</p>
  <!-- end .content --></div>
  <div class="footer">
    <p>Footer</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
</html>
