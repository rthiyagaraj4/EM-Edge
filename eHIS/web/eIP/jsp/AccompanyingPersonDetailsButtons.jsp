<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
	function closeWindow(name)
	{
		if (name == "YedButton")
			window.returnValue= "Y"; 
		else window.returnValue= "N"; 
		parent.window.close();
	}
	</script>
</head>                         
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
%>
	<table width="100%" cellpadding="0" cellspacing="0" >
	<tr>
		<td align="right" width="" class='BODYCOLORFILLED'>
		<input type="button" class="button" name='YedButton' id='YedButton' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels")%>" onclick="closeWindow(this.name);">
		<input type="button" class="button"  name='NoButton' id='NoButton' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="closeWindow(this.name);">
		</td>
	</tr>
	</table>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

