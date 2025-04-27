<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
	//String description = request.getParameter("desc_val")==null?"":request.getParameter("desc_val");
	
	
%>
<html>
<head>
<title><fmt:message key="Common.ComponentLookup.label" bundle="${common_labels}"/></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name='CAComponentCriteriaFrame' id='CAComponentCriteriaFrame' src='../../eCA/jsp/CAComponentLookUpCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling="no" style='height:24vh;width:100vw'></iframe>
	<iframe name='CAComponentFrame' id='CAComponentFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=auto style='height:56vh;width:100vw'> 
	<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0vh;width:100vw'></iframe> 
	
</head>
</html>

