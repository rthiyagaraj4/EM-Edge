<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");	
%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<title>
<fmt:message key="Common.ComponentLookup.label" bundle="${common_labels}"/>
</title>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eAM/js/DiscrMsrCompSectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name='CAComponentCriteriaFrame' id='CAComponentCriteriaFrame' src='../../eAM/jsp/DiscrMsrCompLookupCriteria.jsp?calledFrom=<%=calledFrom%>' frameborder=0 scrolling="no" style='height:20vh;width:100vw'></iframe>
	<iframe name='CAComponentFrame' id='CAComponentFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto style='height:72vh;width:100vw'></iframe> 
	<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=0 style='height:0vh;width:100vw'></iframe> 
	
</head>
</html>

