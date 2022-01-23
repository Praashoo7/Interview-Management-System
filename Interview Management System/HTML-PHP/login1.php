<html>
<head>
<link rel="stylesheet" type="text/css" href="style2.css">
	<title>Add Data</title>
</head>
<body>
<?php
	$str1=$_GET['username'];
	$str2=$_GET['password'];	
	$us='user';
	$ps='user';
		{
			if($str1==$us && $str2==$ps)
			{	
				echo "<br>";
				echo "<br>";
				echo"Login Successfull";
				echo "<br>";
				echo "<br>";
				echo "<a href='test11.html'>Start the Test</a>";
			}
			else
			{
				echo '<script>alert("Username or Password is Incorrect")</script>';
				echo "<br>";
				echo "<br>";
				echo "<br>";
				echo "<br>";
				echo "<br>";
				echo "<br>";
				echo "<a href='adminlogin.html'>Login Again</a>";
				
			}
		}
?>	
</body>
</html>