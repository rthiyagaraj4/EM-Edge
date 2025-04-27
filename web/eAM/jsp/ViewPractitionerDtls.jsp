<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%--
	FileName	: ViewPractitionerDtls.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	<script language='javascript' src='../../eAM/js/OPSPractitioner.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title>
		<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/>
		</title>
</head>
<%
request.setCharacterEncoding("UTF-8");	
//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String practitioner_id = request.getParameter("practitioner_id") ;
	
%>

<iframe name='query' id='query' src='../../eAM/jsp/ViewPractQueryRes.jsp?practitioner_id=<%=practitioner_id%>' frameborder=0 scrolling='no' noresize style='height:71vh;width:95vw' frameborder="0"></iframe>
<iframe name='closeButton' id='closeButton' src='' scrolling='no' frameborder=0 noresize style='height:5vh;width:85vw' frameborder="0"></iframe>


</html>

