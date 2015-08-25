<?php
$servername="mysql3.000webhost.com";
$username="a6269982_hj";
$password="hj1610";
$database="a6269982_1610";

mysql_connect($servername,$username,$password);
@mysql_select_db($database) or die("Unable to select database");

if( $_GET["name"] || $_GET["id"] || $_GET["status"])
  {
     $emp_name=$_GET['name'];
     $emp_id=$_GET['id'];
     $statusvar=$_GET['status'];


// update table

  }

else
{

$query1="select * from Emp_entries";
$sth=mysql_query($query1);
$rows=array();
while($r=mysql_fetch_assoc($sth))
{
$rows[]=$r;
}
echo json_encode($rows);
}

mysql_close();

?>	