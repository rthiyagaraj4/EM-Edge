<!DOCTYPE html>
<html>
<head>
<title>Confirmation Message</title>
<br><br>
<script language="javascript" type="text/javascript">
window.onload = function()
{
   var messageDiv = document.getElementById('dlgMessage');
   if ( messageDiv != null && typeof(messageDiv) != "undefined" )
     messageDiv.innerHTML = window.dialogArguments;
} 
function confirmClick(args)
{
   window.returnValue = args;
   window.close();
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<div id="dlgMessage">
</div>
<br><br>
&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" value="Yes" id="btnYes" onclick="javascript:confirmClick('Y')"/>&nbsp&nbsp&nbsp&nbsp&nbsp
<input type="button" value="No" id="btnNo" onclick="javascript:confirmClick('N');"/>
</body>
</html>

