<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <%@ page contentType="text/html;charset=UTF-8" %>
 <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<BODY CLASS="MESSAGE" OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>

<p align="left">
<%
request.setCharacterEncoding("UTF-8");	
	String error=request.getParameter( "err_num" );

	if ( error != null ) out.println( error ) ;
%>
</p>
</BODY>

