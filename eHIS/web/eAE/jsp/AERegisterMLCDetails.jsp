<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<html> 
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eAE/js/AERegisterAttn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function closing(tiTle)	
{
	if (AECheckMaxLimit(glc_details,tiTle,2000))
	{
		window.returnValue = document.getElementById("glc_details").value;
		window.close();
	}
}
function doInitialize()
{
	var val 	= window.dialogArguments;
	if(val==null) val='';
	document.getElementById("glc_details").value=val;
	document.getElementById("glc_details").focus();
}
</script>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
    String title = request.getParameter("call_from");
          title = (title==null)?"":title;
		  if(!title.equals("") && title.equalsIgnoreCase("MLC"))
		      title = "MLC Details";
		  else if(!title.equals("") && title.equalsIgnoreCase("IR"))
			  title = "Incident Remarks";
		 else title ="";
   String disabled = request.getParameter("disabled");
		 disabled = (disabled==null)?"":disabled;
%>
<title><%=title%></title>
</head>
<body style='background-color:#E2E3F0;' onload='doInitialize()' onKeyDown = 'lockKey()'>
<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr>
		<td align='left' class='label' width='10%'></td>
	</tr>
	<tr>
		<td align='left' width='80%' class='label'>&nbsp;&nbsp;<textarea name="glc_details" rows="8" cols="50" onkeypress="checkMaxLimit(this,2000)" <%=disabled%> onBlur="makeValidString(this);return AECheckMaxLimit(this,'<%=title%>',2000)"></textarea></td>
	</tr>
</table>
	<center><input type='Button' class='Button' name='Ok' id='Ok' value='  OK  ' onclick="closing('<%=title%>')"></center>	
</body>
</html>

