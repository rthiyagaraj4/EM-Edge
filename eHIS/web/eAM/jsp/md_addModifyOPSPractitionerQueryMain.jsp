<!DOCTYPE html>
<%--
	FileName	: md_addModifyOPSPractitionerQueryMain.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
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
	String facilityId = request.getParameter("facilityId");
		if(facilityId == null) facilityId="";
	accessRightRecSet.clearAll();

%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/OPSPractitioner.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='f_query_add_mod_query' id='f_query_add_mod_query' 	 src='../../eAM/jsp/md_addModifyOPSPractitionerQuery.jsp?facilityId=<%=facilityId%>' frameborder=0 noresize scrolling='no' style='height:24vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_res' id='f_query_add_mod_res' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:73vh;width:100vw'></iframe>

</html>

