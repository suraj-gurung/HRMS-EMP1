<html>
<head>
<title>Jquery login page validation</title>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js">
</script>
<script type="text/javascript">
$(document).ready(function(){
$('#submit').click(function(){
var username=$('#user').val();
var password=$('#pass').val();

if(username=="")
{
$('#dis').slideDown().html("<span>Please type Username</span>");
return false;
}
if(password=="")
{
$('#dis').slideDown().html('<span id="error">Please type Password</span>');
return false;
}
});
});
</script>
</head>
<body>

<fieldset style="width:250px;">
<form method="post" action="index.php">
Jquery login page validation

<label id="dis"></label><br>
Username: <input type="text" name="user" id="user" /><br />
Password: <input type="password" name="pass" id="pass" /><br /><br />
<center><input type="submit" name="submit" id="submit" /></center>
</form>

</fieldset>
</body>
</html>