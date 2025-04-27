<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<title><fmt:message key="Common.item.label" bundle="${common_labels}"/></title>
	</head>
<%
	String params			= request.getQueryString() ;
	String bean_id		= request.getParameter("bean_id");
	String bean_name		= request.getParameter("bean_name");
	ConsumableOrderBean bean			= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
%>
	<iframe name="fram_cnItemLkpCriteria" id="fram_cnItemLkpCriteria" frameborder="0" scrolling="no" noresize src="ComsumableOrderItemLookupCriteria.jsp?<%= params %>" style="height:26vh;width:100vw"></iframe>
	<iframe name="fram_cnItemLkpResult" id="fram_cnItemLkpResult" frameborder="0" scrolling="yes" noresize src="../../eCommon/html/blank.html" style="height:60vh;width:100vw"></iframe>
	<iframe name="fram_cnItemLkpButtons" id="fram_cnItemLkpButtons" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html?<%= params %>" style="height:7vh;width:100vw"></iframe>
</HTML>
<%
	putObjectInBean(bean_id,bean,request);
%>

