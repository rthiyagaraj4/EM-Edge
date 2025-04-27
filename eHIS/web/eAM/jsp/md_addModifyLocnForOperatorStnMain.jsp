<!DOCTYPE html>

<%--
	FileName	: md_addModifyLocnForOperatorStnMain.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	accessRightRecSet.clearAll();
	String facilityID = request.getParameter("facilityID");
		if(facilityID == null) facilityID="";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/md_LocnForOperatorStation.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='f_query_add_mod_query' id='f_query_add_mod_query' 	 src='../../eAM/jsp/md_addModifyLocnForOperatorStnQuery.jsp?facilityID=<%=facilityID%>' frameborder=0 noresize scrolling='no' style='height:35vh;width:98vw'></iframe>
<iframe name='f_query_add_mod_res' id='f_query_add_mod_res' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:63vh;width:98vw'></iframe>

</html>

