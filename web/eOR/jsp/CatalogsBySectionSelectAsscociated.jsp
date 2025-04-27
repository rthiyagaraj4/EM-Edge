<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html> 
	<head>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
	
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<form name="" id="">

<table width="100%" cellspacing='0' cellspacing='0'>
<tr>
	<td width='8%' class="COMMON_TOOLBAR">
	<input type='button' onclick="parent.parent.select()" value='Selected' name='Selected' id='Selected' class='BUTTON'></input>
	</td>


	<td width='10%' class="COMMON_TOOLBAR">
	<input type='button' onclick="onApply();" value='Associated' name='Associated' id='Associated' align='left' class='BUTTON'></input>
	</td>

	

</tr>
</table>
</form>

</html>
									

