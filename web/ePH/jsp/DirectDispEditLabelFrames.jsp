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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params			= request.getQueryString() ;
%>
<head>
     <title><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></title>
</head>
<iframe name="edit_label" id="edit_label" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/DirectDispEditLabel.jsp?<%= params %>" style="height:100vh;width:100vw"></iframe><iframe name="dummyFrame" id="dummyFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:0vh;width:100vw"></iframe>
</HTML>

