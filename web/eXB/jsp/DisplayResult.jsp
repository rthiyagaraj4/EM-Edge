<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html> 

<%@ page contentType="text/html;charset=UTF-8" %>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%> 

<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script> 
<script language="JavaScript">
function formLoad()	{							   
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
											   
</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="formLoad()">
<form>
<p align="left">																					    
<%
	String result = (String)request.getParameter("message");
%>
<%= result %>									    
</p>	
</form>
</BODY>															  
</html>																						 		 

