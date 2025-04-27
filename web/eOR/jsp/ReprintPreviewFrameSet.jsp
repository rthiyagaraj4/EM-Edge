<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
20/05/2020	IN010142		Sivabagyam M		20/05/2020		Ramesh G		CA-Common-Existing Order-View consent
---------------------------------------------------------------------------------------------------------
*/
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%String function_from = request.getParameter("function_from");
	function_from = (function_from == null) ? "":function_from;
	String order_id = request.getParameter("order_id");
	order_id = (order_id == null) ? "":order_id;
	String order_line_num = request.getParameter("order_line_num");
	order_line_num = (order_line_num == null) ? "":order_line_num;
	String consent_ref_id = request.getParameter("consent_ref_id");
	consent_ref_id = (consent_ref_id == null) ? "":consent_ref_id;
	String consent_name = request.getParameter("consent_name");
	consent_name = (consent_name == null) ? "":consent_name;
	String RecordBy = request.getParameter("RecordBy");
	RecordBy = (RecordBy == null) ? "":RecordBy;
	String RecordedDate = request.getParameter("RecordedDate");
	RecordedDate = (RecordedDate == null) ? "":RecordedDate;
	String LastRecordedBy = request.getParameter("LastRecordedBy");
	LastRecordedBy = (LastRecordedBy == null) ? "":LastRecordedBy;
	String LastRecordedDate = request.getParameter("LastRecordedDate");
	LastRecordedDate = (LastRecordedDate == null) ? "":LastRecordedDate;
	String consentid = request.getParameter("consentid");
	consentid = (consentid == null) ? "":consentid;	
 
	//String finalString="&order_id="+order_id+"&order_line_num="+order_line_num+"&consent_ref_id="+consent_ref_id+"&consent_name="+consent_name+"&RecordBy="+RecordBy+"&RecordedDate="+RecordedDate+"&LastRecordedBy="+LastRecordedBy+"&LastRecordedDate="+LastRecordedDate+"&consentid="+consentid;
	//String finalString="&order_id="+order_id+"&order_line_num="+order_line_num+"&RecordedDate="+RecordedDate+"&LastRecordedDate="+LastRecordedDate+"&consent_ref_id="+consent_ref_id+"&consent_name="+consent_name+"&RecordBy="+RecordBy+"&LastRecordedBy="+LastRecordedBy+"&consentid="+consentid;//IN010142
 
	//String finalString="&order_id="+order_id+"&order_line_num="+order_line_num+"&consent_ref_id="+consent_ref_id+"&consent_name="+consent_name+"&RecordBy="+RecordBy+"&RecordedDate="+RecordedDate+"&LastRecordedBy="+LastRecordedBy+"&LastRecordedDate="+LastRecordedDate+"&consentid="+consentid;
 
	String finalString="&order_id="+order_id+"&order_line_num="+order_line_num+"&RecordedDate="+RecordedDate+"&LastRecordedDate="+LastRecordedDate+"&consent_ref_id="+consent_ref_id+"&consent_name="+consent_name+"&RecordBy="+RecordBy+"&LastRecordedBy="+LastRecordedBy+"&consentid="+consentid;
	//System.out.println("ReprintPreviewFrameSet.jsp-------------finalString------->"+finalString); 
 
	%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <title><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></title>
 <%if(function_from.equals("EXISTING_CONSENT_DETAILS")){%>
	<iframe name="preview" id="preview"   src="../../eOR/jsp/ExistingOrderMultipleConsentDetails.jsp?<%=finalString%>" frameborder="none" border="none" scrolling="no" noresize style="height:8vh;width:99vw"></iframe> 
	<iframe name="preview" id="preview"   src="../../eOR/jsp/ReprintPreview.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" noresize style="height:87vh;width:99vw"></iframe> 
	<iframe name="preview_button" id="preview_button" src="../../eOR/jsp/ReprintPreviewButton.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="no" noresize style="height:7vh;width:99vw"></iframe> 

 <%}else{%>
	<iframe name="preview" id="preview"   src="../../eOR/jsp/ReprintPreview.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" noresize style="height:92vh;width:99vw"></iframe> 
	<iframe name="preview_button" id="preview_button" src="../../eOR/jsp/ReprintPreviewButton.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="no" noresize style="height:8vh;width:99vw"></iframe> 

<%}%>

