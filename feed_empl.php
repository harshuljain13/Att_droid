<?php
$servername="mysql3.000webhost.com";
$username="a6269982_hj";
$password="hj1610";
$database="a6269982_1610";

if( $_GET["name"] || $_GET["id"] || $_GET["store"] || $_GET["remove"])
  {
     $emp_name=$_GET['name'];
     $emp_id=$_GET['id'];
     $storevar = $_GET['store'];
     $removevar=$_GET['remove'];

//echo $emp_name;echo "<br/>";
//echo $emp_id;echo "<br/>";
//echo $storevar;echo "<br/>";
//echo $removevar;echo "<br/>";
  }

mysql_connect($servername,$username,$password);
@mysql_select_db($database) or die("Unable to select database");

if($storevar=="1" && $removevar=='0')
{
//echo "insert values";
$query1="insert into Emp_entries values('$emp_name','$emp_id')";
mysql_query($query1);
}

if($storevar=='0' && $removevar=='1')
{
//echo "remove values";
$query2="DELETE FROM Emp_entries WHERE CONVERT(Emp_entries.Maker_id USING UTF8)='$emp_id' LIMIT 1";
mysql_query($query2);
}

//echo "hi";echo "<br/>";
mysql_close();
//echo "hi1";echo "<br/>";
?>	