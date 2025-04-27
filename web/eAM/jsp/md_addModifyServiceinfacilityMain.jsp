<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId= request.getParameter("facilityId");
		if(facilityId == null) facilityId="";
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eAM/js/Serviceinfacility.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='f_query_add_mod_query' id='f_query_add_mod_query' 	 src='../../eAM/jsp/md_addModifyServiceinfacility.jsp?facilityId=<%=facilityId%>' frameborder=0 noresize scrolling='no' style='height:28vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_result' id='f_query_add_mod_result' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:70vh;width:100vw'></iframe>
</html>

