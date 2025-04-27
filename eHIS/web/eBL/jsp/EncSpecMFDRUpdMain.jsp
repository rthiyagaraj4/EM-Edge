<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230228							MMS-DM-CRF-0209.5			Namrata Charate
*/ %>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<HTML>

<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=request.getParameter("title") %></title>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			System.err.println("params in multi factor deduct rule is: "+params);
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String facility_id = (String)session.getAttribute("facility_id");
%>
		<iframe name='EncSpecMFDRUpdTab' id='EncSpecMFDRUpdTab'	src='EncSpecMFDRUpdTab.jsp?<%=params%>' frameborder=0 noresize style='height:5vh;width:100vw'></iframe> 
		<iframe name='ServAndItemsCatDtlsFrame' id='ServAndItemsCatDtlsFrame'	src='EncSpecServAndItemsCatDtlsFrame.jsp?<%=params%>' frameborder=0   noresize style='height:85vh;width:100vw'></iframe> 
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:10vh;width:100vw'></iframe> 
		
			
<script>   
</script>
</HTML> 

