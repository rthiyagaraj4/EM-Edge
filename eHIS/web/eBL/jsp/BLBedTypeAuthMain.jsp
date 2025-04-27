<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!--
<title>Authorization</title>
-->
<title><fmt:message key="eBL.AUTH_SCREEN.label" bundle="${bl_labels}"/></title>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<%
	//unused variable, commented on 09/06/05
	//String params = request.getQueryString() ;
	%>
<iframe name='bl_bedtype_auth' id='bl_bedtype_auth' src='BLBedTypeAuth.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
<iframe name='dummyFrame1' id='dummyFrame1'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>


