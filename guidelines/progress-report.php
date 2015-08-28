<?php
$servername="mysql3.000webhost.com";
$username="a6269982_hj";
$password="hj1610";
$database="a6269982_1610";

mysql_connect($servername,$username,$password);
@mysql_select_db($database) or die("Unable to select database");


$query1="Select Name,Maker_id,
count(case when status='P' then 1 end) as Present_days,count(case when status='A' then 1 end) as Absent_days from Aug_attendance group by Maker_id";

$sth=mysql_query($query1);

$rows=array();
while($r=mysql_fetch_assoc($sth))
{
$rows[]=$r;
}
echo json_encode($rows);



mysql_close();
echo "hi1";


?>