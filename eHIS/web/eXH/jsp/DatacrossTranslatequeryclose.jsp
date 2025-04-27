<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>

  <html>
<head>
<%
String sStyle	="IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<table border='0' cellspacing='0' cellpadding='0' width='100%' >
<tr ><td class=white></td></tr>
<tr><td class=white align='right'><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type='button' class='button' value='Ok' onClick='windowclose()'></td></tr>	

</table>
<script> 

function windowclose()
{
parent.window.returnValue=escape(parent.frames[0].document.getElementById("Translate_query").value);
parent.window.close();

}

</script>
</body>
</html>		   

