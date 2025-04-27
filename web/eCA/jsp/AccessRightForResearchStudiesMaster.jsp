<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*" %>
<!--jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/ --> 
<%
	request.setCharacterEncoding("UTF-8");
	//accessRightRecSet.clearAll();
	//String facility_id = request.getParameter("facility_id");
		//if(facility_id == null) facility_id="";
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eCA/js/AccessRightForResearchStudies.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<iframe name='f_query_add_mod_query' id='f_query_add_mod_query' 	 src='../../eCA/jsp/AccessRightForResearchStudiesQuery.jsp' frameborder=0 noresize scrolling='no' style='height:20vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_res' id='f_query_add_mod_res' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:80vh;width:100vw'></iframe>
</html>

