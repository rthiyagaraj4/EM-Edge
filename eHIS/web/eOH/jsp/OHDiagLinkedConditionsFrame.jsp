<!DOCTYPE html>
<html>
	<%@ page contentType="text/html; charset=UTF-8"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
	<%	request.setCharacterEncoding("UTF-8");	%>

	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<head>
	<!-- eOH.LinkedCondition.Label -->
		<title><fmt:message key="eOH.LinkedCondition.Label" bundle="${oh_labels}"/></title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	 <iframe name='OHDiagLinkedConditionsHeaderFrame' id='OHDiagLinkedConditionsHeaderFrame' frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/OHDiagLinkedConditionsHeader.jsp?<%=request.getQueryString()%>" style='height:10%;width:100vw'></iframe><iframe name="OHDiagLinkedConditionsFrame" id="OHDiagLinkedConditionsFrame" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/OHDiagLinkedConditions.jsp?<%=request.getQueryString()%>" style="height:100vh;width:100vw"></iframe> 
</html>
<%
%>


