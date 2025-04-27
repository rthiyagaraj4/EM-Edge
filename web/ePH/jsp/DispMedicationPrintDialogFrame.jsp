<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params			= request.getQueryString()+"&buttons=no&CalledFrom=PrintDialog" ;
%>
	<head>
		 <title><fmt:message key="Common.print.label" bundle="${common_labels}"/>/<fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></title>
	</head>
		<iframe name="printSelectFrame" id="printSelectFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="DispMedicationPrintDialog.jsp?<%= params %>" style="height:13vh;width:100vw"></iframe>
		<iframe name="editLabelFrame" id="editLabelFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="DispMedicationEditLabel.jsp?<%= params %>" style="height:78vh;width:100vw"></iframe>
		<iframe name="buttonFrame" id="buttonFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="DispMedicationPrintDialogButtons.jsp?<%= params %>" style="height:5vh;width:100vw"></iframe>
		<iframe name="dummyFrame" id="dummyFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:0vh;width:100vw"></iframe>
</HTML>

