<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String params			= request.getQueryString()+"&buttons=no&CalledFrom=PrintDialog" ;
%>
	<head>
		 <title><fmt:message key="Common.print.label" bundle="${common_labels}"/>/<fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></title>
	</head>
    <iframe id='printSelectFrame' name="printSelectFrame" id="printSelectFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="DirectDispPrintDialog.jsp?<%= params %>" style='height:20vh;width:98vw'></iframe>
    <iframe id='editLabelFrame' name="editLabelFrame" id="editLabelFrame" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="DirectDispEditLabel.jsp?<%= params %>" style='height:66vh;width:98vw'></iframe>
    <iframe id='buttonFrame' name="buttonFrame" id="buttonFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="DirectDispPrintDialogButtons.jsp?<%= params %>" style='height:5vh;width:98vw'></iframe>
    <iframe name="dummyFrame" id="dummyFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:0vh;width:98vw"></iframe> 
   
   </HTML>

