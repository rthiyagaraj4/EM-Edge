<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/OtherStaff.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title>
		<fmt:message key="Common.OtherStaffDetails.label" bundle="${common_labels}"/>
		</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String other_staff_id = request.getParameter("other_staff_id") ;
	
%>

<iframe name='query' id='query' src='../../eAM/jsp/OtherStaffQueryResView.jsp?other_staff_id=<%=other_staff_id%>' frameborder=0 scrolling='no' noresize style='height:96vh;width:100vw'></iframe>
	<iframe name='closeButton' id='closeButton' src='../../eAM/html/closeButton.html' scrolling='no' frameborder=0 noresize style='height:4vh;width:100vw'></iframe>


</html>

