<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	accessRightRecSet.clearAll();
	String facility_id="";
	facility_id=request.getParameter("facility_id");
	if(facility_id == null) facility_id="";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/md_Practforteam.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='f_query_add_mod_query' id='f_query_add_mod_query' 	 src='../../eAM/jsp/md_addModifyPractForTeamQuery.jsp?facility_id=<%=facility_id%>' frameborder=0 noresize scrolling='no' style='height:30vh;width:98vw'></iframe>
<iframe name='f_query_add_mod_res' id='f_query_add_mod_res' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:50vh;width:98vw'></iframe>

</html>

