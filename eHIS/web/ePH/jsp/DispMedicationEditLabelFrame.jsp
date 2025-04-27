<!DOCTYPE html>

  
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String params			= request.getQueryString() ;
	String sMode				=	request.getParameter("mode");  
%>
	<head>
<%
		if(sMode != null && sMode.equals("preview")){
%>
			<title><fmt:message key="Common.Preview.label" bundle="${common_labels}"/> <fmt:message key="Common.Label.label" bundle="${common_labels}"/></title>
<%
		} 
		else {
%>
			<title><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></title>
<%
		}
%>
	</head>
	<iframe name="edit_label" id="edit_label" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="DispMedicationEditLabel.jsp?<%= params %>" style="height:100vh;width:99vw"></iframe><iframe name="dummyFrame" id="dummyFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:0vh;width:99vw"></iframe>
</HTML>

