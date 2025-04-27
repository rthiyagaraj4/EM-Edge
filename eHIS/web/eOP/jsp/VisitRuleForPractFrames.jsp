<!DOCTYPE html>

<%--
	FileName	: PractitionerQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*" %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%
	request.setCharacterEncoding("UTF-8");
	accessRightRecSet.clearAll();
	String facility_id = request.getParameter("facility_id");
		if(facility_id == null) facility_id="";
		String queryString = request.getQueryString();
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eOP/js/VisitRuleForPract.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<iframe name='f_query_add_mod_query' id='f_query_add_mod_query' src='../../eOP/jsp/VisitRuleForPractCriteria.jsp?facility_id=<%=queryString%>' frameborder=0 noresize scrolling='no' style='height:22vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_res' id='f_query_add_mod_res' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:75vh;width:100vw'></iframe>
</html>

