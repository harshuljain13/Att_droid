<?php
$servername="mysql3.000webhost.com";
$username="a6269982_hj";
$password="hj1610";
$database="a6269982_1610";

mysql_connect($servername,$username,$password);
@mysql_select_db($database) or die("Unable to select database");

if(file_get_contents('php://input'))
  {
     $json=file_get_contents('php://input');
     $jsonarray=json_decode($json);
     $datem=date("Y-m-d");
switch(date('m')){

case 1: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into jan_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 2: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into feb_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 3: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into march_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 4:
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into apr_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 5: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into may_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 6: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into june_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 7:
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into july_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 8: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into Aug_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 9: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into sept_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 10: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into oct_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 11: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into nov_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

case 12: 
foreach($jsonarray as $employees)
{
foreach($employees as $employee)
{
$query1="insert into dec_attendance values('$employee->Name','$employee->Maker_id','$employee->status','$datem')";
mysql_query($query1);
}
}
break;

//switch end
}

//if-end
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