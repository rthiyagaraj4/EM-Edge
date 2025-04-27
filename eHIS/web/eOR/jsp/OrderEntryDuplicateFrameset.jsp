<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------
09/10/2017	  IN063973		Raja S		10/10/2017		Ramesh G			SS-CRF-0058	
------------------------------------------------------------------------------------------
*/ 
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	/* Initialize Function specific start */
		//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		 OrderEntryBean bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
	/* Initialize Function specific end */
	HashMap hashValues				= bean.getAllValues();
	String dupl_message				= "";  // For Lab is installed and panel dupl check
	String susp_message				= "";  // For Lab is installed and catalog is suspended
//	String ord_dupl_message			= "";
	String rd_appt = "";
	int dupl_count_alert			= 0;
	int dupl_count_error			= 0;
	int conflict_exam_count_records = 0; int conflict_records = 0;
	if(hashValues!=null)
	{
		dupl_message		 		= bean.checkForNull((String)hashValues.get("dupl_message"),"");
		susp_message		 		= bean.checkForNull((String)hashValues.get("susp_message"),"");
		rd_appt						= bean.checkForNull((String)hashValues.get("rd_appt"),""); // For Radialogy Appointment
		dupl_count_alert 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_alert"),"0"));
		dupl_count_error 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_error"),"0"));
		conflict_exam_count_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_exam_count_records"),"0"));
		conflict_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_records"),"0"));
	}
%>	
<html>
<head>
<%
	//String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	if(!susp_message.equals("")) 
	{ 
	%>	
		<title><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></title>
	<% 
	} 
	else if(conflict_exam_count_records > 0)
	{ 
	%>
		<title><fmt:message key="eOR.ExamConflicts.label" bundle="${or_labels}"/></title>
	<% 
	} 
	else if(rd_appt.equals("X"))
	{ 
	%>
		<title><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></title>
	<% 
	} 
	else 
	{ %>
		<title><fmt:message key="eOR.DuplicateCheck.label" bundle="${or_labels}"/></title>
	<% 
	} 
	%>	

</head>
	<iframe name='OrderEntryDuplicate' id='OrderEntryDuplicate' src='OrderEntryDuplicate.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize  style='height:75vh;width:100vw'></iframe>
	<iframe name='OrderEntryDuplicateButton' id='OrderEntryDuplicateButton' src='OrderEntryDuplicateButton.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize style='height:17vh;width:100vw'></iframe>

</html>

