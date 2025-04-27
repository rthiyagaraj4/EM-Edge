<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %><%
request.setCharacterEncoding("UTF-8");	
	String patient=request.getParameter("Patient_id");
	session.putValue( "patient_id", patient );
%>
<html>
<head>
<title>
	Patient Photo
</title>
  <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr><td align="center" width="100%">&nbsp;</td></tr>
	<tr>
		<td align="center" width="100%">
			<jsp:include page="../../eCommon/jsp/photo_display.jsp" flush="true"/>
		</td>	
	</tr>
	<tr><td align="center" width="100%">&nbsp;</td></tr>
</table>
</html>
