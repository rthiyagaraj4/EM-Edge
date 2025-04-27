<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
24/08/2013    IN030284		Chowminya G 	Created:To capture Pre-consultation orders in Appointment Scheduling
---------------------------------------------------------------------------------------------------------------
-->
<%@page contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
 
<% 
	//String searchText = request.getParameter("searchText");
String bean_id = "refusalOrdersBean" ;
String bean_name = "eOR.RefusalOrdersBean";
RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>


<html>
<title><fmt:message key="Common.Order.label" bundle="${common_labels}"/> <fmt:message key="Common.Selection.label" bundle="${common_labels}"/></title>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String appt_ref_no=(request.getParameter("appt_ref_no")==null||request.getParameter("appt_ref_no").equals("null"))?"":request.getParameter("appt_ref_no");
	String Mode=(request.getParameter("Mode")==null||request.getParameter("Mode").equals("null"))?"":request.getParameter("Mode");
	String facilityid=(request.getParameter("facilityid")==null||request.getParameter("facilityid").equals("null"))?"":request.getParameter("facilityid");
	Orderables.setapptrefno(appt_ref_no);
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOR/js/ORApptOrderSelection.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%

if("View".equals(Mode))
{
%>
	<iframe name="OrderSelectionSelectedText" id="OrderSelectionSelectedText" style='height:90vh;width:100vw' frameborder="0" scrolling="auto" noresize src = "../../eOR/jsp/ORApptOrderSelectionSelectedText.jsp?<%=request.getQueryString()%>"></iframe>
	<iframe name="messageFrameReference" id="messageFrameReference" style='height:7vh;width:100vw' frameborder="0" scrolling="no" noresize src = "../../eCommon/html/blank.html"></iframe>
	
<%
}
else
{
%>
	<iframe name="OrderSelectionCriteriaFrame" id="OrderSelectionCriteriaFrame" style='height:20vh;width:100vw' frameborder="0" scrolling="no" noresize src = "../../eOR/jsp/ORApptOrderSelection.jsp?<%=request.getQueryString()%>"></iframe>
		<iframe name="OrderSelectionResult" id="OrderSelectionResult" style='height:42vh;width:100vw' src="../../eCommon/html/blank.html" scrolling='no' frameborder="0" noresize></iframe>
		<iframe name="OrderSelectionSelectedText" id="OrderSelectionSelectedText" style='height:30vh;width:100vw' frameborder="1" scrolling="auto" noresize src = "../../eOR/jsp/ORApptOrderSelectionSelectedText.jsp?<%=request.getQueryString()%>"></iframe>
		<iframe name="OrderSelectionRecordButton" id="OrderSelectionRecordButton" style='height:6vh;width:100vw' frameborder="0" scrolling="no" noresize src = "../../eOR/jsp/ORApptOrderSelectionRecordButtons.jsp?<%=request.getQueryString()%>" scrolling="no"></iframe>
		<iframe name="messageFrameReference" id="messageFrameReference" style='height:0vh;width:100vw' frameborder="0" scrolling="no" noresize src = "../../eCommon/html/blank.html"></iframe>

<%
}
%>
</html>

